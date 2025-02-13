package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
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

    //check if database/collection for mongo and sql exists

    // can read and print the zipfile fine
    ZipFile zipFile = new ZipFile("..\\data\\movies_post_2010.zip");
    ZipEntry entry = zipFile.getEntry("movies_post_2010.json");
    InputStream is = zipFile.getInputStream(entry);
    byte[] data = new byte[is.available()];
    is.read(data);

    String jsonDump = new String(data);

    // System.out.println(jsonDump);

    //Add to the list when instantiated as an object
    ArrayList<Imdb> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new StringReader(jsonDump));

        String line;
        
        try {
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Ignore empty lines
                    JsonReader jsonReader = Json.createReader(new StringReader(line));
                    JsonObject jsonObject = jsonReader.readObject();
                    // System.out.println(jsonObject);
                    // System.out.println(counter);
                    
                    String title = jsonObject.getString("title");
                    Integer vote_average = jsonObject.getInt("vote_average");
                    Integer vote_count = jsonObject.getInt("vote_count");
                    String release_date = jsonObject.getString("release_date");
                    Integer revenue = jsonObject.getInt("revenue");
                    Integer budget = jsonObject.getInt("budget");
                    Integer runtime = jsonObject.getInt("runtime");

                    //omg no time to figure it out. in model add another constructor, takes in all string, will parse whatever
                    //instantiate the imdb object
                    Imdb i = new Imdb(title, vote_average, vote_count, release_date, revenue, budget, runtime);
                    list.add(i);
                    
                    System.out.println(i.toString());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      // json.readLine();
      //test output
      // System.out.println(jsonDump);

      zipFile.close();
    }





  }
