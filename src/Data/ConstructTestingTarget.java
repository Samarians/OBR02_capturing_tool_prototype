package Data;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructTestingTarget {

    public List<String> readLinksFromFile(String filePath) {
        List<String> linkList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line
                String[] links = line.split(",\\s*"); // Split by comma and optional whitespace
                // Add each link to the list
                linkList.addAll(Arrays.asList(links));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the list to an array
        return linkList;
    }
}