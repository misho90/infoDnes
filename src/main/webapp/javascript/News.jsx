import React, {Component} from 'react';

var divStyle = {
  maxWidth: "20rem"
};

class News extends Component{
  render() {
    return(
      <div> <NewsFetch /> </div>
    );
  }
}

class NewsFetch extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    fetch("/api/rss/printRSS")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      return (
        <div>
          {items.map(item => (
            <Article site={item.sourceName} title={item.title} description={item.description} key={item.guid} url={item.link}/>
          ))}
        </div>
      );
    }
  }
}

class Article extends Component{
 render(){
   var articleStyle;
   if (this.props.site === 'dnes.bg'){
      articleStyle = "card text-white bg-primary mb-3 marginLeftFivePercent inline";
   }
   if (this.props.site === 'investor.bg'){
     articleStyle = "card text-white bg-success mb-3 marginLeftFivePercent inline";
   }
   if (this.props.site === 'vesti.bg'){
     articleStyle = "card text-white bg-danger mb-3 marginLeftFivePercent inline";
   }
   if (this.props.site === 'plovdiv24'){
     articleStyle = "card text-white bg-warning mb-3 marginLeftFivePercent inline";
   }
   if (this.props.site === 'varna24'){
     articleStyle = "card text-white bg-info mb-3 marginLeftFivePercent inline";
   }
   return(
     <a href={this.props.url} target="_blank">
       <div className={articleStyle} style={divStyle}>
         <div className="card-header">{this.props.site}</div>
         <div className="card-body">
           <h4 className="card-title">{this.props.title}</h4>
           <p className="card-text">{this.props.description}</p>
         </div>
       </div>
     </a>
     );
   }
  }


export default News;
