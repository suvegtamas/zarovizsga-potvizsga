package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    public int getNumberOfMales(String path) {
        int result = 0;
        Path file = Path.of(path);
        try(BufferedReader br = Files.newBufferedReader(file)) {
            skipFirstLine(br);
            result = processLineAndCountMales(result, br);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
        return result;
    }

    private int processLineAndCountMales(int result, BufferedReader br) throws IOException {
        String line;
        while((line= br.readLine()) != null) {
            String[] parts = line.split(",");
            String gender = parts[4];
            if(gender.equalsIgnoreCase("male")) {
                result++;
            }
        }
        return result;
    }

    private void skipFirstLine(BufferedReader bufferedReader) throws IOException{
        bufferedReader.readLine();
    }

}
