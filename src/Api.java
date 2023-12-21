import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api extends GUI {
    public static void getRequests(String text){

        try {

            URL url = new URL("https://www.omdbapi.com/?apikey=bb7dc99b&t=" + text);

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

                // Get the data for GUI
                title = jo.get("Title").asString();
                year = jo.get("Year").asString();
                genre = jo.get("Genre").asString();
                plot = jo.get("Plot").asString();
                imdbRate = jo.get("imdbRating").asString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
