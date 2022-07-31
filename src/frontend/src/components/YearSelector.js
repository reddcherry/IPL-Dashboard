import React from 'react'
import { Link } from 'react-router-dom';

function YearSelector({teamName}) {
 let years = [];
 const startYear = 2008;
 const endYear = 2022;

 for (let i =endYear; i>=startYear; i--){
  years.push(i);
 }
 console.log(years);
  return (
    <ol>
      {years.map((year) => (
        <Link to={`/teams/${teamName}/matches/${year}`}>
          <li key={year}>{year}</li>
        </Link>
      ))}
    </ol>
  );
}

export default YearSelector
