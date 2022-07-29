import React from "react";

function MatchDetailCard({match}) {
  return (
    <div>
      <h3>{match.team1} vs {match.team2}</h3>
    </div>
  );
}

export default MatchDetailCard;
