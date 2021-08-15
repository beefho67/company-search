import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import SearchPage from "./pages/SearchPage.js";
import CreditorDetailPage from "./pages/CreditorDetailPage";
import "./styles.css";

const NoMatchRoute = () => <div>404 Page</div>;

const App = () => {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={SearchPage} />
        <Route path="/creditor/:creditorId" exact component={CreditorDetailPage} />
        <Route component={NoMatchRoute} />
      </Switch>
    </Router>
  );
};

export default App;
