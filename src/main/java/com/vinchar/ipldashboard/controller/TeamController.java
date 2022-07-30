package com.vinchar.ipldashboard.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

// @GetMapping("/teams")
// public List<Team> getTeam(){

//  return teamRepository.findAll();
// }

// @GetMapping("/teams/{teamName}")
// public Team findTeam(@PathVariable String teamName){

//  Team team = teamRepository.findByTeamName(teamName);

// //  System.out.println(team);
//  return team;

// }

@GetMapping("/matches")
public List<Match> findAllMatches(){
 return matchRepository.findAll();
}

@GetMapping("/matches/{teamName}")
public List<Match> findTeam1(@PathVariable String teamName){
 return matchRepository.findByTeam1OrTeam2OrderByDateDesc(teamName, 4);
}

@GetMapping("/team/{teamName}/matches")
public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){

  // List <Match> list = matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName);
  // List<Match> finalList = new ArrayList<>();
  // list.stream().filter(match-> match.getDate().getYear()==year).forEach(match-> finalList.add(match));;


  LocalDate startDate = LocalDate.of(year, 1, 1);
  LocalDate endDate = LocalDate.of(year, 12, 31);


   return matchRepository.getMatch(teamName, startDate, endDate);

}


}
