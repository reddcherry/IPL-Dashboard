import React, { useEffect, useState } from 'react'
import MatchDetailCard from '../components/MatchDetailCard'
import MatchSmallCard from '../components/MatchSmallCard'

function TeamPage() {

 const [team, setTeam] = useState([]);

 const fetchMatches = async()=>{
  const response = await fetch(
    "http://localhost:8080/matches/Chennai%20Super%20Kings"
  );
  const data = await response.json();
 setTeam(data);

 }


 useEffect(()=>{
  fetchMatches();
 },[])

  if(team.length==0) return;

  return (
    <div className='teamPage'>
      <h1>{team[0].team1}</h1>
      <MatchDetailCard match={team[0]}/>
      {team.slice(1).map(match=><MatchSmallCard key={match.id} match={match}/>)}
    </div>
  )
}

export default TeamPage
