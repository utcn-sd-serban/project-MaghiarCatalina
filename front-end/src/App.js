import React from 'react';
import './App.css';

import {HashRouter, Switch, Route} from "react-router-dom";
import SmartUserLogin from './view/SmartUserLogin';
import SmartFrontPage from './view/SmartFrontPage';
import SmartViewAllFoods from './view/SmartViewAllFoods';
import SmartCreateFood from './view/SmartCreateFood';
import SmartSearchFood from './view/SmartSearchFood';


const App =()=> (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartUserLogin} path="/" />
        <Route exact={true} component={SmartFrontPage} path="/home" />
        <Route exact={true} component={SmartViewAllFoods} path="/foods/view-all" />
        <Route exact={true} component={SmartCreateFood} path="/foods/create" />
        <Route exact={true} component={SmartSearchFood} path="/foods/:name" />
      </Switch>
    </HashRouter>      
  </div>
)

export default App;
