import { Fragment, useState } from "react";
import { Redirect, Route, Switch } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home";
import MatchPage from "./pages/MatchPage";
import TeamPage from "./pages/TeamPage";

function App() {
  const [totalMatches, setTotalMatches] = useState(0);
  const [totalWins, setTotalWins] = useState(0);
  const matchCountSender = (totalMatches, totalWins) => {
    setTotalMatches(totalMatches);
    setTotalWins(totalWins);
  };

  return (
    <Fragment>
      <Switch>
        <Route path={"/"} exact>
          <Home />
        </Route>
        <Route path={"/teams/:teamName"} exact>
          <TeamPage totalMatches={totalMatches} totalWins={totalWins} />
        </Route>
        <Route path={"/teams/:teamName/matches/:year"}>
          <MatchPage matchCountSender={matchCountSender} />
        </Route>
        <Route path={"*"}>
          <Redirect to={"/"} />
        </Route>
      </Switch>
    </Fragment>
  );
}

export default App;
