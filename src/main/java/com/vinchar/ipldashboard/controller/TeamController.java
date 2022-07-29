package com.vinchar.ipldashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.vinchar.ipldashboard.model.Match;
import com.vinchar.ipldashboard.model.Team;
import com.vinchar.ipldashboard.repo.MatchRepository;
import com.vinchar.ipldashboard.repo.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
 
private TeamRepository teamRepository;
private MatchRepository matchRepository;


@Autowired
public TeamController(MatchRepository matchRepository, TeamRepository teamRepository){
 this.matchRepository = matchRepository;
  this.teamRepository = teamRepository;

}

// @Autowired
// public TeamController(TeamRepository teamRepository){
//  this.teamRepository = teamRepository;
// }

@GetMapping("/teams")
public List<Team> getTeam(){

 return teamRepository.findAll();
}

@GetMapping("/teams/{teamName}")
public Team findTeam(@PathVariable String teamName){

 return teamRepository.findByTeamName(teamName);
}

@GetMapping("/matches")
public List<Match> findAllMatches(){
 return matchRepository.findAll();
}

@GetMapping("/matches/{teamName}")
public List<Match> findTeam1(@PathVariable String teamName){

 // Pageable page = PageRequest.of(0, 4);
 return matchRepository.findByTeam1OrTeam2OrderByDateDesc(teamName, 5);
}
}
