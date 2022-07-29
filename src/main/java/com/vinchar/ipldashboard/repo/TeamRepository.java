package com.vinchar.ipldashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.vinchar.ipldashboard.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
 
 public Team findByTeamName(String teamName);
}
