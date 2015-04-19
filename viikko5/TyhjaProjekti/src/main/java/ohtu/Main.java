package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
            System.out.println("Opiskelijanumero: ");
            String studentNr = s.next();

            if (args.length > 0) {
                studentNr = args[0];
            }

            String url = "http://ohtustats-2015.herokuapp.com/students/" + studentNr + "/submissions";

            HttpClient client = new HttpClient();
            GetMethod method = new GetMethod(url);
            client.executeMethod(method);

            InputStream stream = method.getResponseBodyAsStream();

            String bodyText = IOUtils.toString(stream);

//            System.out.println("json-muotoinen data:");
//            System.out.println(bodyText);

            Gson mapper = new Gson();
            Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

//            System.out.println("Oliot:");
            int hours = 0;
            int sum = 0;
            for (Submission submission : subs) {
                System.out.println(submission);
                hours += submission.getHours();
                sum += submission.getTehtyjaTehtavia();
            }
            System.out.println("Yhteensä: " + sum + " ja " + hours + " tuntia");
    }
}
