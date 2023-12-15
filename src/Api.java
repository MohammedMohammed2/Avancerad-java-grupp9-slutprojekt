import javax.swing.*;
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


                System.out.println(response);

                //Gson gson = new Gson();
               // JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}