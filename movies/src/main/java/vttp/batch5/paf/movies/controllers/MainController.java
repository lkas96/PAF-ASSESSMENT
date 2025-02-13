package vttp.batch5.paf.movies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;


@RestController
@RequestMapping("/api")
public class MainController {

  @Autowired
  private MySQLMovieRepository sqlRepo;
  
  @Autowired
  private MongoMovieRepository mongoRepo;

  // TODO: Task 3
  //http://localhost:8080/api/summary?count=5
   @GetMapping("/summary")
   public String getSummary(@RequestParam int count) {
    System.out.println(count); //test value   
    //okay value is passed in correctly yaaas omg 4.20pm alr rip

    //take the number of movies
    //distinct count the in the mongodb since its there and not mysql
    List<Document> directors = mongoRepo.getDirectorsByCount();

    return new String();
   }
   

  
  // TODO: Task 4


}
