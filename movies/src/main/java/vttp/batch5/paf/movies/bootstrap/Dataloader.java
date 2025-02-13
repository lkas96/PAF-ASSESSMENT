package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import antlr.collections.List;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.paf.movies.models.Imdb;

@Component
public class Dataloader implements CommandLineRunner {

  // TODO: Task 2

  // check for zip file open and process

  // {"title":"Sin City: A Dame to Kill For",
  // "vote_average":6,
  // "vote_count":3812,
  // "status":"Released",
  // "release_date":"2014-08-20",
  // "revenue":39400000,"runtime":102,
  // "budget":65000000,
  // "imdb_id":"tt0458481",
  // "original_language":"en",
  // "overview":"Some of Sin City's most hard-boiled citizens cross paths with a
  // few of its more reviled inhabitants.",
  // "popularity":58,
  // "tagline":"There is no justice without sin.",
  // "genres":"Crime, Action, Thriller",
  // "spoken_languages":"English",
  // "casts":"John Wirt, Callie Hernandez, Mike Davis, Greg Ingram... many more
  // names",
  // "director":"Robert Rodriguez, Frank Miller",
  // "imdb_rating":7,
  // "imdb_votes":173162,
  // "poster_path":"/50kALxDX4mmzIRljbNbPY0u4cie.jpg"}

  @Override
  public void run(String... args) throws Exception {

    // check if database/collection for mongo and sql exists

    // can read and print the zipfile fine
    ZipFile zipFile = new ZipFile("..\\data\\movies_post_2010.zip");
    ZipEntry entry = zipFile.getEntry("movies_post_2010.json");
    InputStream is = zipFile.getInputStream(entry);

    // String jsonDump = new String(data);

    // System.out.println(jsonDump);

    // Add to the list when instantiated as an object
    ArrayList<Imdb> list = new ArrayList<>();

    // force read as UTF-8 encoding to prevent character issues
    BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

    String line;

    try {
      while ((line = reader.readLine()) != null) {
        if (!line.trim().isEmpty()) { // Ignore empty lines
          JsonReader jsonReader = Json.createReader(new StringReader(line));
          JsonObject jsonObject = jsonReader.readObject();
          // System.out.println(jsonObject);
          // System.out.println(counter);

          //get the values and error handling
          String title = jsonObject.getString("title", "title");

          int vote_average = jsonObject.containsKey("vote_average") && jsonObject.isNull("vote_average") ? jsonObject.getInt("vote_average") : 0;

          int vote_count = jsonObject.containsKey("vote_count") && jsonObject.isNull("vote_count") ? jsonObject.getInt("vote_count") : 0;

          String status = jsonObject.getString("status", "no status");

          String release_date = jsonObject.getString("release_date", "0000-00-00");

          int revenue = jsonObject.containsKey("revenue") && !jsonObject.isNull("revenue") ? jsonObject.getInt("revenue") : 0;

          int runtime = jsonObject.containsKey("runtime") && !jsonObject.isNull("runtime") ? jsonObject.getInt("runtime") : 0;

          int budget = jsonObject.containsKey("budget") && !jsonObject.isNull("budget") ? jsonObject.getInt("budget") : 0;

          String imdb_id = jsonObject.getString("imdb_id");

          String original_language = jsonObject.getString("original_language", "");

          String overview = jsonObject.getString("overview", "");

          int popularity = jsonObject.containsKey("popularity") && !jsonObject.isNull("popularity") ? jsonObject.getInt("popularity") : 0;

          String tagline = jsonObject.getString("tagline", "");

          String genres = jsonObject.getString("genres", "");

          String spoken_languages = jsonObject.getString("spoken_languages", "");

          String casts = jsonObject.getString("cast", "");

          String director = jsonObject.getString("director", "");

          int imdb_rating = jsonObject.containsKey("imdb_rating") && !jsonObject.isNull("imdb_rating") ? jsonObject.getInt("imdb_rating") : 0;

          int imdb_votes = jsonObject.containsKey("imdb_votes") && !jsonObject.isNull("imdb_votes") ? jsonObject.getInt("imdb_votes") : 0;

          String poster_path = jsonObject.getString("poster_path", "");


          // Instantiate IMDb object wii all the 20 fields
          Imdb i = new Imdb(title, vote_average, vote_count, status, release_date, revenue, runtime, budget, imdb_id, original_language, overview, popularity, tagline, genres, spoken_languages, casts, director, imdb_rating, imdb_votes, poster_path);
          
          list.add(i);
          System.out.println(i.toString());

          //why are the values all null, its going through the goddamn lines but everything is null bruh
          //okay fixed it lmao some error in the model
          //also added weird constrcutor that has fields2 instead of all
          //now seems to be printing fine, okay i gotta go poop now
          


        }

      }
       //test list
       System.out.println(list.size()); //69515 records processing into the arraylist
       


       //now time for the date processing filtering.
       ArrayList<Imdb> filtered = new ArrayList<>();

       for (int i = 0; i < list.size(); i++){
        //loops through all the array then process the date shit thing 2018 minimum
        
       }

    } catch (Exception e) {
      e.printStackTrace();
    }

    // json.readLine();
    // test output
    // System.out.println(jsonDump);

    zipFile.close();
  }

}