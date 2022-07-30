import { Fragment } from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import MatchPage from './pages/MatchPage';
import TeamPage from './pages/TeamPage';

function App() {
  return (
    <Fragment>
      <Switch>
        <Route path={"/teams/:teamName"} exact>
          <TeamPage />
        </Route>
        <Route path={"/teams/:teamName/matches/:year"}>
          <MatchPage />
        </Route>
      </Switch>
    </Fragment>
  );
}

export default App;
