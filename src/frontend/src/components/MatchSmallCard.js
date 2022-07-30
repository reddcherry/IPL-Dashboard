import React from "react";
import { Link, useParams } from "react-router-dom";
import classes from './MatchSmallCard.module.css'

function MatchSmallCard({match}) {

  const params = useParams();
  const oppositeTeam =
   match.team1 === params.teamName ? match.team2 : match.team1;
   // console.log(match);
     const hasTeamWon = match.winningTeam === params.teamName;

   const mainClass =
     classes.matchSmallCard + " " + (hasTeamWon ? classes.won : classes.lost);

   const oppTeamLink = `/teams/${oppositeTeam}`

  return (
    <div className={mainClass}>
      <h3>
        vs <Link to={oppTeamLink} > {oppositeTeam}</Link>
      </h3>
      <h6>{match.date}</h6>
      <h6>
        {match.winningTeam} won by {match.margin} {match.wonBy}
      </h6>
    </div>
  );
}

export default MatchSmallCard;
