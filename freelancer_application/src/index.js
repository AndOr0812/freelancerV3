import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';

import {BrowserRouter, Route, Switch} from 'react-router-dom';

import reduxThunk from 'redux-thunk';

import App from './components/app';
import SignUp from './containers/signup';
import Login from './containers/login';
import LogOut from './containers/logout';
import reducers from './reducers';
import Profile from "./components/profile";
import Home from "./containers/home";
import EditProfile from './containers/editprofile';
import PostProject from "./containers/postproject";
import AllProjects from "./containers/allProjects";
import RelevantProjects from "./containers/relevantProjects";
import ProjectDetail from "./containers/projectDetail";
import PlaceBid from "./containers/placeBid";
import Transactions from "./components/transactions";
import Dashboard from "./containers/Dashboard";

const createStoreWithMiddleware = applyMiddleware(reduxThunk)(createStore);

export const store = createStoreWithMiddleware(reducers);

ReactDOM.render(
  <Provider store={store}>
      <BrowserRouter>
          <Switch>
              <Route path="/profile" component={Profile}/>
              <Route path="/editprofile" component={EditProfile}/>
              <Route path="/post_project" component={PostProject}/>
              <Route path="/allProjects" component={AllProjects}/>
              <Route path="/relevantProjects" component={RelevantProjects}/>
              <Route path="/projectDetail/:id" component={ProjectDetail}/>
              <Route path="/transactions" component={Transactions}/>
              <Route path="/placeBid" component={PlaceBid}/>
              <Route path="/logout" component={LogOut}/>
              <Route path="/signup" component={SignUp}/>
              <Route path="/login" component={Login}/>
              <Route path="/home" component={Home}/>
              <Route path="/" component={App}/>
              <Route path="/dashboard" component={Dashboard}/>
          </Switch>
      </BrowserRouter>
  </Provider>
  , document.querySelector('#maincontainer'));
