import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GenreSearch extends GUI{
        public static void getRequests(String text){

            try {

                URL url = new URL("https://www.omdbapi.com/?apikey=bb7dc99b&s=" + text + "&page=1" );

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set the request method to GET
                connection.setRequestMethod("GET");

                // Get the response code t.ex 400, 404, 200 är ok
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {

                    // Read the response from the InputStream
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();

                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    // Close reader
                    reader.close();

                    // Turn repsonse to as object
                    JsonValue jv = Json.parse(response.toString());
                    JsonObject jo = jv.asObject();
                    JsonArray ja = jo.get("Search").asArray();
                    JsonObject inner = ja.get(0).asObject();
                    System.out.println(ja);

                    // Get the data for GUI
                    title = inner.getString("Title","fins inte");
                    year = inner.getString("Year","finns inte");
                    genre = text;
                    //plot = jo.get("Plot").asString();
                    imdbRate = inner.getString("imdbRating","finns inte");
                    //poster = jo.get("Poster").asString();

                /*
                om vi ska använda rating i array

                JsonArray ja = jo.get("Ratings").asArray();
                JsonObject rate = ja.get(0).asObject();

                String rating = rate.getString("Value", "finns inte");

                 */

                    System.out.println(title);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
