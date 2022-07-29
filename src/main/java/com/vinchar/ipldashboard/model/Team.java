package com.vinchar.ipldashboard.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private String teamName;
 private long totalMatches;
 private long totalWins;

 @javax.persistence.Transient
 private List<Team> teamList;

 
 public String getTeamName() {
  return teamName;
 }
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public void setTeamName(String teamName) {
  this.teamName = teamName;
 }
 public long getTotalMatches() {
  return totalMatches;
 }
 public void setTotalMatches(long totalMatches) {
  this.totalMatches = totalMatches;
 }
 public long getTotalWins() {
  return totalWins;
 }
 public void setTotalWins(long totalWins) {
  this.totalWins = totalWins;
 }
 public Team(String teamName, long totalMatches) {
  this.teamName = teamName;
  this.totalMatches = totalMatches;
 }

 public Team(){

 }

 
 
}
