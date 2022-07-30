import React from "react";
import { Link, useParams } from "react-router-dom";

function MatchDetailCard({ match }) {
 
 const params = useParams();
 const oppositeTeam = match.team1===params.teamName? match.team2 : match.team1;
 // console.log(match);

 const oppTeamLink = `/teams/${oppositeTeam}`

 return (
   <div className="MatchDetailCard">
     <h2>Latest Match</h2>
     <h3>
       vs <Link to = {oppTeamLink}>{oppositeTeam}</Link>
     </h3>
     <h4>{match.date}</h4>
     <h4>at {match.venue}</h4>
     <h4>
       {match.winningTeam} won by {match.margin} {match.wonBy}
     </h4>
   </div>
 );
}

export default MatchDetailCard;
