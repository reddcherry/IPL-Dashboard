import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import classes from './Home.module.css'
import TeamTile from '../components/TeamTile';

function Home() {
const [teams, setTeams] = useState([]);
const {teamName} = useParams();

useEffect(()=>{
 const fetchAllTeams = async()=>{
  const response = await fetch("http://localhost:8080/teams");
  const data = await response.json();
  setTeams(data);
 }
 fetchAllTeams();
},[])

// console.log(teams);
  return (
    <div className={classes.homePage}>
      <div className={classes.headerSection}>
        <h1 className={classes.appName}>IPL DashBoard</h1>
      </div>
      <div className={classes.teamGrid}>
        {teams.map((team) => (
          <TeamTile team={team} key={team.id} />
        ))}
      </div>
    </div>
  );
}

export default Home
