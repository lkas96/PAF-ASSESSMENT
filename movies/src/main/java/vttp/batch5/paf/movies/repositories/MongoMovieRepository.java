package vttp.batch5.paf.movies.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
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

    // System.out.printf(">>> after insert: %s\n", insertedDoc.toJson());

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
//  hmmm something liek that
//  select how many directors to see/ or how many entries to see basically.

//  db.imdb.aggregate([
//     {
//         $group: {
//             _id: "$directors",
//             count: {$sum: 1},
//             imdb_id : {$push: "$_id"}            //this will give us the number of movies per director
//         }
//     }
// ])

 public List<Document> getDirectorsByCount() {
    GroupOperation groupByDirector = Aggregation.group("directors").push("imdb_id").as("List_Movie_Ids").count().as("Number_Of_Movies");

    SortOperation sortByCount = Aggregation.sort(
        Sort.by(Direction.DESC, "count"));
    

    Aggregation pipeline = Aggregation.newAggregation(groupByDirector, sortByCount);

    AggregationResults<Document> results = template.aggregate(pipeline, "movies", Document.class);

    return null;
}
}
