import React from "react";
import { Link, useParams } from "react-router-dom";
import classes from "./MatchDetailCard.module.css";

function MatchDetailCard({ match }) {
  const params = useParams();
  const oppositeTeam =
    match.team1 === params.teamName ? match.team2 : match.team1;
  // console.log(match);
  
    
  

  const oppTeamLink = `/teams/${oppositeTeam}`;
    const hasTeamWon = match.winningTeam === params.teamName;
  const mainClass = classes.matchDetailCard + " " + (hasTeamWon ? classes.won : classes.lost)


  return (
    <div
      className={mainClass}
    >
      <div>
        <h2>Latest Match</h2>
        <h3 className={classes}>
          <Link to={oppTeamLink}>vs {oppositeTeam}</Link>
        </h3>
        <h4 className={classes.matchDate}> {match.date}</h4>
        <h4 className={classes.matchVenue}>at {match.venue}</h4>
        <h4 className={classes.matchResult}>
          {match.winningTeam} won by {match.margin} {match.wonBy}
        </h4>
      </div>
      <div className={classes.additionalDetail}>
        <h4>First Innings</h4>
        <p>{match.team1}</p>
        <h4>Second Innings</h4>
        <p>{match.team2}</p>
        <h4>Player of Match</h4>
        <p>{match.playerOfMatch}</p>
      </div>
    </div>
  );
}

export default MatchDetailCard;
