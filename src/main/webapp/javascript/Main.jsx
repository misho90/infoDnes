import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Weather from './Weather'
import News from './News'
import Currencies from './Currencies'
import Header from './Header'
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

const routing = (
    <Router>
      <div>
        <Header />
        <hr />
        <Switch>
          <Route exact path="/" component={Weather} />
          <Route exact path="/Weather" component={Weather} />
          <Route path="/News" component={News} />
          <Route path="/Currencies" component={Currencies} />
        </Switch>
      </div>
    </Router>
);

ReactDOM.render(routing, document.getElementById("root"));
