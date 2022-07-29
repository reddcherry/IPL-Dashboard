package com.vinchar.ipldashboard.repo;

import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.vinchar.ipldashboard.model.Match;

//@RepositoryRestResource(path = "matches")
public interface MatchRepository extends JpaRepository<Match, Long>{

 List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);
 // List<Match> getByTeam1(String teamName1);

 default List<Match> findByTeam1OrTeam2OrderByDateDesc(String teamName, int count){

   return  getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));

 }

}
