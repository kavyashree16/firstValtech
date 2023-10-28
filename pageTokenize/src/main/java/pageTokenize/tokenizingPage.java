package pageTokenize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tokenizingPage implements ServletContextListener {

    private String websiteURL = "https://example.com/page"; // Default URL

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            // Open a connection to the website
            URL url = new URL(websiteURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the content from the page
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            try (FileWriter fileWriter = new FileWriter("output.txt")) {
                fileWriter.write(content.toString());
            }

            BufferedReader fileReader = new BufferedReader(new FileReader("output.txt"));
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                text.append(line);
            }
            fileReader.close();

            String[] words = text.toString().split("\\s+");

            // Eliminate common words
            List<String> commonWords = Arrays.asList("the", "and", "a", "an"); // Add more as needed
            List<String> uncommonWords = new ArrayList<>();
            for (String word : words) {
                if (!commonWords.contains(word.toLowerCase())) {
                    uncommonWords.add(word);
                }
            }

            int count = uncommonWords.size();
            int count2 = commonWords.size();
            // Display the count (For demonstration purposes)
            System.out.println("The count of uncommon words is: " + count);
            System.out.println("the count of common words is:  "+ count2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}