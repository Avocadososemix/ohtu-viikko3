package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "013467135";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        url = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String kurssi = Request.Get(url).execute().returnContent().asString();
        Gson mapper = new Gson();
        Course kurs = mapper.fromJson(kurssi, Course.class);
        System.out.println(kurs);
        System.out.println("\nopiskelijanumero: " + studentNr);

        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        for (Submission submission : subs) {
            System.out.println(submission);
        }
        int hours = 0;
        int exercises = 0;
        for (Submission sub : subs) {
            hours += sub.getHours();
            exercises += sub.getExercises().length;
        }
        System.out.println("\nyhteensä: " + exercises + " tehtävää " + hours + " tuntia");

        url = "https://studies.cs.helsinki.fi/ohtustats/stats";
        String statsResponse = Request.Get(url).execute().returnContent().asString();

        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
        parsittuData.
        
        System.out.println("kurssilla yhteensä ");

    }
}
