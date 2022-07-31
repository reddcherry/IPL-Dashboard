import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import MatchSmallCard from '../components/MatchSmallCard'
import YearSelector from '../components/YearSelector';
import classes from './MatchPage.module.css'

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
  
  return (
    <div className={classes.matchPage}>
      <YearSelector teamName={teamName} />
      <div>
        {matches.length === 0 ? (
          <h2>
            {teamName} didn't play in {year}
          </h2>
        ) : (
          <h2>{teamName} in {year}</h2>
        )}
        {matches.map((match) => (
          <MatchSmallCard match={match} key={match.id} />
        ))}
      </div>
    </div>
  );
}

export default MatchPage
