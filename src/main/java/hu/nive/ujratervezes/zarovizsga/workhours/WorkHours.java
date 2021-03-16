package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public static final String DELIMETER = ",";
    public static final String DELIMETER_TO_STRING = ": ";

    public String minWork(String file) {
        String result = "";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            result = getResultFromFile(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        return result;
    }

    private String getResultFromFile(BufferedReader reader) throws IOException {
        String result = "";
        String line;
        int min = Integer.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(DELIMETER);
            int actualHours = Integer.parseInt(parts[1]);
            if (actualHours < min) {
                min = actualHours;
                result = parts[0] + DELIMETER_TO_STRING + parts[2];
            }
        }
        return result;
    }
}
