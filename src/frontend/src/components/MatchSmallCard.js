import React from "react";
import { Link, useParams } from "react-router-dom";

function MatchSmallCard({match}) {

  const params = useParams();
  const oppositeTeam =
   match.team1 === params.teamName ? match.team2 : match.team1;
   // console.log(match);

   const oppTeamLink = `/teams/${oppositeTeam}`

  return (
    <div className="MatchSmallCard">
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
