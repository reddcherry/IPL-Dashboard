package com.vinchar.ipldashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.vinchar.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

 private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

 @Override
 public Match process(MatchInput matchInput) throws Exception {

  Match match = new Match();

  match.setID(Long.valueOf(matchInput.getID()));
  match.setCity(matchInput.getCity());
  match.setDate(LocalDate.parse(matchInput.getDate()));
  match.setPlayerOfMatch(matchInput.getPlayer_of_Match());
  match.setVenue(matchInput.getVenue());
  match.setTossWinner(matchInput.getTossWinner());
  match.setTossDecision(matchInput.getTossDecision());
  match.setWinningTeam(matchInput.getWinningTeam());
  match.setWonBy(matchInput.getWonBy());
  match.setPlayerOfMatch(matchInput.getPlayer_of_Match());
  match.setTeam1Players(matchInput.getTeam_1_Players().toString());
  match.setTeam2Players(matchInput.getTeam_2_Players().toString());
  match.setUmpire1(matchInput.getUmpire1());
  match.setUmpire2(matchInput.getUmpire2());
  match.setTeam1(matchInput.getTeam1());
  match.setTeam2(matchInput.getTeam2());
  match.setMargin(matchInput.getMargin());


  String firstInningsTeam, secondInningsTeam;

  if (matchInput.getTossDecision().equals("bat")) {
   firstInningsTeam = matchInput.getTossWinner();
   secondInningsTeam = firstInningsTeam.equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
  } else {
   secondInningsTeam = matchInput.getTossWinner();
   firstInningsTeam = secondInningsTeam.equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
  }

  return match;

 }
}
