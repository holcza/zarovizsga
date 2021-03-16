package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file){
        String result = "";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String line;
            int min = Integer.MAX_VALUE;
            while ((line = reader.readLine())  != null) {
                String[] parts = new String[3];
                int actualHours= Integer.parseInt(parts[1]);
                if (actualHours<min){
                    min = actualHours;
                    result = line;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }
}
