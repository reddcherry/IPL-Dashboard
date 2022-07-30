import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import MatchDetailCard from '../components/MatchDetailCard'
import MatchSmallCard from '../components/MatchSmallCard'

function TeamPage() {

 const [team, setTeam] = useState([]);
 const params = useParams();
 // console.log(params.teamName);



 const fetchMatches = async()=>{
  const response = await fetch(
    `http://localhost:8080/matches/${params.teamName}`
  );
  const data = await response.json();
 setTeam(data);

 }


 useEffect(()=>{
  fetchMatches();
 },[params.teamName])

  if(team.length==0) return <h1>No Team Found</h1>;
  
 

  return (
    <div className='teamPage'>
      <h1>{params.teamName}</h1>
      <MatchDetailCard match={team[0]}/>
      {team.slice(1).map(match=><MatchSmallCard key={match.id} match={match}/>)}
    </div>
  )
}

export default TeamPage
