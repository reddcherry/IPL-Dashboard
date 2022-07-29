package com.vinchar.ipldashboard.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.vinchar.ipldashboard.data.JobCompletionNotificationListener;
import com.vinchar.ipldashboard.data.MatchDataProcessor;
import com.vinchar.ipldashboard.data.MatchInput;
import com.vinchar.ipldashboard.model.Match;

@Configuration
@EnableBatchProcessing
public class AppConfig {
 @Autowired
 public JobBuilderFactory jobBuilderFactory;
 @Autowired
 public StepBuilderFactory stepBuilderFactory;

 @Bean
 public FlatFileItemReader<MatchInput> reader() {
  return new FlatFileItemReaderBuilder<MatchInput>()
    .name("MatchInputItemReader")
    .resource(new ClassPathResource("IPL_Matches_2008_2022.csv"))
    .delimited()
    .names(new String[] { "ID", "City", "Date", "Season", "MatchNumber", "Team1", "Team2", "Venue", "TossWinner",
      "TossDecision", "SuperOver", "WinningTeam", "WonBy", "Margin", "method", "Player_of_Match", "Team1Players",
      "Team2Players", "Umpire1", "Umpire2" })
    .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
     {
      setTargetType(MatchInput.class);
     }
    })
    .build();
 }

 

 @Bean
 public MatchDataProcessor processor() {
  return new MatchDataProcessor();
 }

 @Bean
 public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
  return new JdbcBatchItemWriterBuilder<Match>()
    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
    .sql(
      "INSERT INTO match (city,id,date,team1,team2,venue,toss_winner,toss_decision,winning_team,won_by,margin,player_of_match,umpire1,umpire2) VALUES (:City,:ID,:date,:team1,:team2,:Venue,:TossWinner,:TossDecision,:WinningTeam,:WonBy,:Margin,:PlayerOfMatch,:Umpire1,:Umpire2)")
    .dataSource(dataSource)
    .build();
 }

 @Bean
 public Job importUSerJob(JobCompletionNotificationListener listener, Step step1){
  return jobBuilderFactory.get("importUserJob")
    .incrementer(new RunIdIncrementer())
    .listener(listener)
    .flow(step1)
    .end()
    .build();
 }

 @Bean
 public Step step1(JdbcBatchItemWriter<Match> writer) {
  return stepBuilderFactory.get("step1")
    .<MatchInput, Match> chunk(25)
    .reader(reader())
    .processor(processor())
    .writer(writer)
    .build();
}


}
