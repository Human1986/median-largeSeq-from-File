package org.myCalculationApp.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reader data
 */
public class ReaderData {

    /**
     * This method read data from file and then save them to list
     * @param path to file
     * @return list of data
     */
    public List<Integer> readDataFromFile(String path) {
        List<Integer> listOfNumbers = new ArrayList<>(10000000);

        checkIfFileExist(Path.of(path));

        // I use the try-with resource to effectively close all resources and eliminate data leak
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while (reader.ready()) {
                String number = reader.readLine();
                listOfNumbers.add(Integer.valueOf(number));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listOfNumbers;
    }

    private void checkIfFileExist(Path path) {
        Files.exists(path);
    }
}
