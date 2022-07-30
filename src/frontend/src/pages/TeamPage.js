import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import MatchDetailCard from "../components/MatchDetailCard";
import MatchSmallCard from "../components/MatchSmallCard";
import classes from "./TeamPage.module.css";
import { PieChart } from "react-minimal-pie-chart";

function TeamPage() {
  const [team, setTeam] = useState([]);
  const params = useParams();
  // console.log(params.teamName);
  const [totalWins, setTotalWins] = useState(0);
  const [totalMatches, setTotalMatches] = useState(0);

  const fetchMatches = async () => {
    const response = await fetch(
      `http://localhost:8080/matches/${params.teamName}`
    );
    const data = await response.json();
    setTeam(data);
  };
  const fetchMatchCount = async () => {
    setTotalMatches(0);
    setTotalWins(0);
    const response = await fetch(
      `http://localhost:8080/team/${params.teamName}/matches?year=2022`
    );
    const data = await response.json();
    if (data.error) {
      return;
    }
    data.forEach((match) => {
      setTotalMatches((totalMatches) => totalMatches + 1);
      if (match.winningTeam === params.teamName) {
        setTotalWins((totalWins) => totalWins + 1);
      }
    });
  };
  console.log(totalMatches);
  console.log(totalWins);
  useEffect(() => {
    fetchMatches();
    fetchMatchCount();
  }, [params.teamName]);

  if (team.length == 0) return <h1>No Team Found</h1>;

  return (
    <div className={classes.teamPage}>
      <div className={classes.teamNameSection}>
        <h1 className={classes.teamName}>{params.teamName}</h1>
      </div>
      <div className={classes.winLossSection}>
        <PieChart
          data={[
            { title: "Wins", value: totalWins, color: "	#006847" },
            {
              title: "Losses",
              value: totalMatches - totalWins,
              color: "#C13C37",
            },
          ]}
        />
      </div>
      <div className={classes.matchDetailSection}>
        <MatchDetailCard match={team[0]} />
      </div>
      {team.slice(1).map((match) => (
        <div key={match.id}>
          {" "}
          <MatchSmallCard match={match} />
        </div>
      ))}
      <div className={classes.more}>
        <Link to="#">More {">"} </Link>
      </div>
    </div>
  );
}

export default TeamPage;
