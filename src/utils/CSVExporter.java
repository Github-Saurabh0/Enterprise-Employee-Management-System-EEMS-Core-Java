package utils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CSVExporter {

    public void writeToCSV(List<String> rows, File file) {

        try (FileWriter writer = new FileWriter(file)) {
            for (String row : rows) {
                writer.write(row + "\n");
            }
            writer.flush();
        } catch (Exception e) {
            System.out.println("CSV export failed: " + e.getMessage());
        }
    }
}
