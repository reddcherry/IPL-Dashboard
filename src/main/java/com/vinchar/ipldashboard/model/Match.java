package com.vinchar.ipldashboard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
 
 @Id
 private long ID;
 private String City; 
 private LocalDate date; 
 private String team1; 
 private String team2; 
 private String Venue; 
 private String TossWinner; 
 private String TossDecision; 
 private String WinningTeam; 
 private String WonBy; 
 private String margin; 
 private String PlayerOfMatch; 
 private String Team1Players; 
 private String Team2Players; 
 private String Umpire1; 
 private String Umpire2;


 
 public Match() {
 }
 public long getID() {
  return ID;
 }
 public void setID(long iD) {
  ID = iD;
 }
 public String getCity() {
  return City;
 }
 public void setCity(String city) {
  City = city;
 }
 public LocalDate getDate() {
  return date;
 }
 public void setDate(LocalDate date) {
  this.date = date;
 }
 public String getTeam1() {
  return team1;
 }
 public void setTeam1(String team1) {
  this.team1 = team1;
 }
 public String getTeam2() {
  return team2;
 }
 public void setTeam2(String team2) {
  this.team2 = team2;
 }
 public String getVenue() {
  return Venue;
 }
 public void setVenue(String venue) {
  Venue = venue;
 }
 public String getTossWinner() {
  return TossWinner;
 }
 public void setTossWinner(String tossWinner) {
  TossWinner = tossWinner;
 }
 public String getTossDecision() {
  return TossDecision;
 }
 public void setTossDecision(String tossDecision) {
  TossDecision = tossDecision;
 }
 public String getWinningTeam() {
  return WinningTeam;
 }
 public void setWinningTeam(String winningTeam) {
  WinningTeam = winningTeam;
 }
 public String getWonBy() {
  return WonBy;
 }
 public void setWonBy(String wonBy) {
  WonBy = wonBy;
 }
 public String getMargin() {
  return margin;
 }
 public void setMargin(String margin) {
  this.margin = margin;
 }

 public String getTeam1Players() {
  return Team1Players;
 }
 public void setTeam1Players(String team1Players) {
  Team1Players = team1Players;
 }
 public String getTeam2Players() {
  return Team2Players;
 }
 public void setTeam2Players(String team2Players) {
  Team2Players = team2Players;
 }
 public String getUmpire1() {
  return Umpire1;
 }
 public void setUmpire1(String umpire1) {
  Umpire1 = umpire1;
 }
 public String getUmpire2() {
  return Umpire2;
 }
 public void setUmpire2(String umpire2) {
  Umpire2 = umpire2;
 }
 public String getPlayerOfMatch() {
  return PlayerOfMatch;
 }
 public void setPlayerOfMatch(String playerOfMatch) {
  PlayerOfMatch = playerOfMatch;
 }

 
}



  