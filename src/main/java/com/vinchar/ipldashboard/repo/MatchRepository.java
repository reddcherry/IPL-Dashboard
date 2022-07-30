package com.vinchar.ipldashboard.repo;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vinchar.ipldashboard.model.Match;


public interface MatchRepository extends JpaRepository<Match, Long>{

 List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

 List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2);
@Query("select m from Match m where (m.team1 = :teamName or m.team2 =:teamName) and m.date between :startDate and :endDate order by date desc")
 List<Match> getMatch(@Param("teamName") String teamName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


 default List<Match> findByTeam1OrTeam2OrderByDateDesc(String teamName, int count){

   return  getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));

 }

}
