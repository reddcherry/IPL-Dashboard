import React from 'react'
import { Link } from 'react-router-dom'
import classes from './TeamTile.module.css'

function TeamTile({team}) {
  return (
    <div className={classes.teamTile}>
      <h1>
        <Link to={`/teams/${team.teamName}`}>{team.teamName}</Link>
      </h1>
    </div>
  );
}

export default TeamTile
