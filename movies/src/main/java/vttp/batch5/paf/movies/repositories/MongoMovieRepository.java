package vttp.batch5.paf.movies.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.Imdb;

@Repository
public class MongoMovieRepository {

    @Autowired
    private MongoTemplate template;

 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void batchInsertMovies() {

 }

 //skip batch insert idk how
 public static final String imdb_collection = "imdb";

 public void InsertOneDocument(Imdb entry){
    // db.imdb.insertOne(
    // {_id: "entry.id",
    //  title: "entry.title",
    //  director: "entry.director",
    //  overview: "entry.overview",
    //  tagline: "entry.tagline",
    //  genres: "entry.genres",
    //  imdb_rating: "entry.rating",    
    //  imdb_votes: "entry.votes"
    // }
    // )

    //just refernece, entry.getProperMethods instead()

    Document toInsert = new Document();
    toInsert.put("_id", entry.getImdb_id());
    toInsert.put("title", entry.getTitle());
    toInsert.put("directors",entry.getDirector());
    toInsert.put("overview", entry.getOverview());
    toInsert.put("tagline", entry.getTagline());
    toInsert.put("genres", entry.getGenres());
    toInsert.put("imdb_rating", entry.getImdb_rating());
    toInsert.put("imdb_votes", entry.getImdb_votes());

    //inserting to db one record duh
    Document insertedDoc = template.insert(toInsert, imdb_collection);

    System.out.printf(">>> after insert: %s\n", insertedDoc.toJson());

}


 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void logError() {

 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //


}
