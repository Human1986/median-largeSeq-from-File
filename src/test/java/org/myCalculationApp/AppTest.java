package org.myCalculationApp;

import org.junit.jupiter.api.Test;
import org.myCalculationApp.data.ArithmeticOperation;
import org.myCalculationApp.data.ReaderData;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    /**
    In order to check test cases you should provide your path to file in FILE_NAME variable
     */

    public final String FILE_NAME = " ".trim(); // Here in quotes is needed to pass the path to your file
    ReaderData read = new ReaderData();
    List<Integer> numbers = read.readDataFromFile(FILE_NAME);
    ArithmeticOperation operation = new ArithmeticOperation();


    @Test
    public void givenListOfNumbers_whenNotEmpty_thenIsNotEmpty() {

        // Given
        List<Integer> list = numbers;

        // When
        boolean notEmpty = ! list.isEmpty();

        //Then
        assertTrue(notEmpty);
    }

    @Test
    public void givenListOfNumbers_whenCalculateMaxNumber_thenGetMaxNumber() {

        // Given
        List<Integer> list = numbers;

        //When
        int expected = 49999978;
        int actual = operation.maxOfNumbers(list);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void givenListOfNumbers_whenCalculateMinNumber_thenGetMinNumber() {

        // Given
        List<Integer> list = numbers;

        //When
        int expected = - 49999996;
        int actual = operation.minOfNumbers(list);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void givenListOfNumbers_whenCalculateMedianNumber_thenGetMedianNumber() {

        // Given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(8);
        numbers.add(14);
        numbers.add(19);

        //When
        double expected = 11;
        double actual = operation.medianOfNumbers(numbers);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void givenListOfNumbers_whenCalculateLargeSequence_thenGetLargeSeqIncrease() {

        StringBuilder builder = new StringBuilder();

        // Given
        List<Integer> listOfSeq = List.of(1, 2, 5, 4, 7, 11, 20, 23, 20, 19, 5, 10, 9, 10, 11, 12, 13, 14, 15);

        // When
        List<Integer> integerList = operation.largerSequenceIncrease(listOfSeq);

        for (Integer number : integerList) {
            builder.append(number).append(" ");
        }

        // Then

        String expected = "9 10 11 12 13 14 15";
        String actual = builder.toString().trim();

        assertEquals(expected, actual);

    }

    @Test
    public void givenListOfNumbers_whenCalculateLargeSequence_thenGetLargeSeqDegrease() {

        StringBuilder builder = new StringBuilder();

        // Given
        List<Integer> listOfSeq = List.of(1, 2, 5, 4, 7, 11, - 3, - 5, - 8, - 25, - 100, -200, 10, 4, 3, 0, 7);

        // When
        List<Integer> integerList = operation.largerSequenceDegrease(listOfSeq);

        for (Integer number : integerList) {
            builder.append(number).append(" ");
        }

        // Then
        String expected = "11 -3 -5 -8 -25 -100 -200";
        String actual = builder.toString().trim();

        assertEquals(expected, actual);

    }


}

