import React, {Component} from 'react'
import './css/weather-icons.min.css'

class Weather extends Component{
  render(){
    return(
      <div className="holder">
        <div className="jumbotron">
          <div className="icon-wrap">
            <i className="wi wi-night-sleet"></i>
          </div>
          <div className='inline TwentyPersentWidth'>
            <div className="condition ">
              <span>Превалявания от дъжд</span>
            </div>
            <div className="temperature">
              <span> -2&deg;C</span>
            </div>
          </div>
          <div className='inline'>
            <div className='inline'>
              <div className="details">
                <span> Усеща се </span>
                <span className="bold right">-5&deg;C </span>
              </div>
              <div className="details width">
                <span> Вятър</span>
                <span className="bold right"> 15км/ч</span>
              </div>
              <div className="details width">
                <span> Видимост</span>
                <span className="bold right"> 9км</span>
              </div>
              <div className="details width">
                <span> Атмосферно налягане &nbsp; </span>
                <span className="bold right"> 1015 hPa</span>
              </div>
              <div className="details width">
                <span> Влажност</span>
                <span className="bold right"> 55%</span>
              </div>
              <div className="details width">
                <span> Изгрев </span>
                <span className="bold right"> 07:15</span>
              </div>
              <div className="details width">
                <span> Залез </span>
                <span className="bold right"> 18:15</span>
              </div>
            </div>
          </div>
          <div className="inline marginLeftFourPercent minWidth">
            <div className="bold fiveDaysForecast">
              <span>Прогноза за следващите 5 дни</span><br/>
            </div>
            <div className="forecast TwentyPersentWidth inline">
              <span>Днес</span><br />
              <i className="wi wi-night-sleet"></i><br />
              <span className="degrees bold">16&deg;C </span><br />
              <span className="degrees">8&deg;C </span><br />
            </div>
            <div className="forecast TwentyPersentWidth inline">
              <span>Съб 20</span><br />
              <i className="wi wi-night-sleet"></i><br />
              <span className="degrees bold">16&deg;C </span><br />
              <span className="degrees">8&deg;C </span><br />
            </div>
            <div className="forecast TwentyPersentWidth inline">
              <span>Нед 21</span><br />
              <i className="wi wi-night-sleet"></i><br />
              <span className="degrees bold">16&deg;C </span><br />
              <span className="degrees">8&deg;C </span><br />
            </div>
            <div className="forecast TwentyPersentWidth inline">
              <span>Пон 22</span><br />
              <i className="wi wi-night-sleet"></i><br />
              <span className="degrees bold">16&deg;C </span><br />
              <span className="degrees">8&deg;C </span><br />
            </div>
            <div className="forecast TwentyPersentWidth inline">
              <span>Сря 23</span><br />
              <i className="wi wi-day-sunny"></i><br />
              <span className="degrees bold">18&deg;C </span><br />
              <span className="degrees">9&deg;C </span><br />
            </div>
          </div>
        </div>
      </div>
    )
  }
}
export default Weather;
