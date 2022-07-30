import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import MatchSmallCard from '../components/MatchSmallCard'

function MatchPage({matchCountSender}) {
  const[matches, setMatches] = useState([]);
  const {teamName, year} = useParams();
  

  const fetchMatches =async ()=>{
    const response = await fetch(
      `http://localhost:8080/team/${teamName}/matches?year=${year}`
    );
    const data = await response.json();
    if(data.error){return} 
    setMatches(data);
 
  }


  
  



  useEffect(()=>{
    fetchMatches();
  }, [teamName, year])



  // console.log(matches);
  // if(matches==null) return;
  return (
    <div className='MatchPage'>
      <h1>MatchPage</h1>
      {matches.map(match=><MatchSmallCard match ={match} key= {match.id} />)}
    </div>
  )
}

export default MatchPage
