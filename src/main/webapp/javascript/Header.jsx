import React, { Component } from 'react'
import './bootstrap.css'
import './App.css'
import CustomLink from './CustomLink'
import logo from './infodnes.jpg'

class Header extends Component {
  render() {
    return(
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <img src={ logo } className="logo"  alt="img"/>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mr-auto">
              <NavLink path='/Weather' label='Времето днес'/>
              <NavLink path='/News' label='Новите днес'/>
              <NavLink path='/Currencies' label='Валутните курсове днес'/>
            </ul>
          </div>
        </nav>
    )
  }
}

class NavLink extends Component {
  render(){
      return(
        <li className="nav-item">
          <CustomLink
           tag='a'
           to={this.props.path}
           className="nav-link">
          {this.props.label}
        </CustomLink>
        </li>
      )
    }
}

export default Header
