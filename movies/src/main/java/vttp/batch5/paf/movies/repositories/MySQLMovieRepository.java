package vttp.batch5.paf.movies.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.Imdb;
import vttp.batch5.paf.movies.Queries.SQL;

@Repository
public class MySQLMovieRepository {
  @Autowired
  private JdbcTemplate template;
  
  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method
  public void batchInsertMovies() {
   
  }

  //SKIP BATCH I CANNOT
  //just manual one record by one record
  public void insertARecord(Imdb entry){
    int rowAdded1 = template.update(SQL.SQL_INSERT_ONE, entry.getImdb_id(), entry.getVote_average(), entry.getVote_count(), entry.getRelease_date(), entry.getRevenue(), entry.getBudget(), entry.getRuntime());
    if (rowAdded1 ==1 ){
      //added successfull
    }
  }
  
  // TODO: Task 3


}
