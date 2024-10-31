package LinkVerification;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuickLaunchNavigationUrlExtractor {
    public static void main(String[] args) {
        // Path to the JSON file
        String jsonFilePath = "src/LinkVerification/od_MCenter_0010_home.json"; // Update with your file path
        // Path to the output file
        String outputFilePath = "C:\\Users\\NHANND12\\Documents\\NHANND12\\Oyabashi\\RightMenuCapture\\logs\\topmenu_title_url\\od_MCenter_Home.txt"; // Update with your desired output file path

        // Load JSON data from the file
        String jsonString = loadJsonFromFile(jsonFilePath);
        if (jsonString == null) {
            System.out.println("Failed to load JSON data from file.");
            return;
        }

        // Parse the JSON string
        JSONObject jsonObject = new JSONObject(jsonString);
        // Access the navigationInfo object nested under spPageContextInfo
        JSONObject navigationInfo = jsonObject.getJSONObject("spPageContextInfo").getJSONObject("navigationInfo");
        //JSONObject navigationInfo = jsonObject.getJSONObject("navigationInfo");

        // Create a StringBuilder to hold the output
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append("Title,Url\n"); // Add header

        // Extract titles and URLs and build the output
        extractTitlesAndUrls(navigationInfo, outputBuilder);

        // Write the output to a file
        writeToFile(outputFilePath, outputBuilder.toString());
    }

    private static String loadJsonFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return null;
        }
    }

    private static void extractTitlesAndUrls(JSONObject jsonObject, StringBuilder outputBuilder) {
        // Check for Title and Url at the current level
        if (jsonObject.has("Title")) {
            outputBuilder.append(jsonObject.getString("Title")).append(",");
        } else {
            outputBuilder.append(",");
        }

        if (jsonObject.has("Url")) {
            outputBuilder.append(jsonObject.getString("Url")).append("\n");
        } else {
            outputBuilder.append("\n");
        }

        // Recursively handle children if they exist
        if (jsonObject.has("quickLaunch")) {
            JSONArray quickLaunchArray = jsonObject.getJSONArray("quickLaunch");
            for (int i = 0; i < quickLaunchArray.length(); i++) {
                extractTitlesAndUrls(quickLaunchArray.getJSONObject(i), outputBuilder);
            }
        }
        if (jsonObject.has("Children")) {
            JSONArray childrenArray = jsonObject.getJSONArray("Children");
            for (int i = 0; i < childrenArray.length(); i++) {
                extractTitlesAndUrls(childrenArray.getJSONObject(i), outputBuilder);
            }
        }
    }

    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Output written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
