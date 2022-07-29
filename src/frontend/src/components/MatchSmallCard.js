import React from "react";

function MatchSmallCard(props) {
  return (
    <div>
      <p>
        {props.match.team1} vs {props.match.team2}
      </p>
    </div>
  );
}

export default MatchSmallCard;
