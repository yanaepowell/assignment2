package assignment2.example.assignment;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) throws JSONException {
        SpringApplication.run(AssignmentApplication.class, args);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.boredapi.com/api/activity"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(response.body());
           

            // Print activity suggestion
             // Extract relevant information
            String activity = jsonResponse.getString("activity");
            String type = jsonResponse.getString("type");
            int participants = jsonResponse.getInt("participants");
            double price = jsonResponse.getDouble("price");
            String link = jsonResponse.getString("link");
            double accessibility = jsonResponse.getDouble("accessibility");
            
            // Print the extracted information
            System.out.println("Activity: " + activity);
            System.out.println("Type: " + type);
            System.out.println("Participants: " + participants);
            System.out.println("Price: " + price);
            System.out.println("Link: " + link);
            System.out.println("Accessibility: " + accessibility);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
