import { Fragment, useState } from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import MatchPage from './pages/MatchPage';
import TeamPage from './pages/TeamPage';

function App() {
  const [totalMatches, setTotalMatches]= useState(0);
  const [totalWins, setTotalWins] = useState(0);
  const matchCountSender = (totalMatches, totalWins)=>{
    setTotalMatches(totalMatches);
    setTotalWins(totalWins);
  }

  return (
    <Fragment>
      <Switch>
        <Route path={"/teams/:teamName"} exact>
          <TeamPage totalMatches={totalMatches} totalWins={totalWins}/>
        </Route>
        <Route path={"/teams/:teamName/matches/:year"}>
          <MatchPage matchCountSender={matchCountSender} />
        </Route>
      </Switch>
    </Fragment>
  );
}

export default App;
