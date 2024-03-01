package org.myCalculationApp.UI;

import org.myCalculationApp.data.ArithmeticOperation;
import org.myCalculationApp.data.ReaderData;

import java.util.*;

/**
 * This class is used as a user interface
 */
public class Display {

    /**
     * Print info about what functions do you want to choose?
     */
    public static void startApplication() {
        ArithmeticOperation operation = new ArithmeticOperation();
        Scanner scanner = new Scanner(System.in);
        ReaderData data = new ReaderData();

        System.out.println("!!! Please provide us the path to your file !!!");
        String pathToFile = getPath(scanner);

        if (pathToFile.isEmpty()) {
            throw new IllegalArgumentException("You did not provide the path to your file. Try again!");
        }

        List<Integer> numbers = data.readDataFromFile(pathToFile);

        System.out.println("Thank you so much!  And welcome to my app \n");
        System.out.println("**********************************************************************************");
        System.out.println("You can perform the following arithmetic operations on the integers " +
                "\n which present in your file as shown below");
        System.out.println("********************************************************************************** \n");


        while (true) {

            // Here we need a map to store all possible operations we can do
            Map<Integer, String> choice = getListOfChoice();

            System.out.println("Please choose the operation from 1 to 7 you would like to do...");
            System.out.println("If you want to exit, please enter the 8  \n");

            for (Map.Entry<Integer, String> entry : choice.entrySet()) {
                System.out.printf("%d -> %s", entry.getKey(), entry.getValue() + "\n");
            }

            int key = scanner.nextInt();

            if (key == 8) {
                System.out.println("Thank you for choosing my app");
                System.out.println("Goodbye! Have a great day!");
                scanner.close();
                break;
            }
            // The actual execution of our function takes place here.
            // The key means number according to which the appropriate actions will be selected
            switch (key) {
                case 1 -> {
                    int max = operation.maxOfNumbers(numbers);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.printf("The maximum number in  this file is -> %d \n", max);
                    int min = operation.minOfNumbers(numbers);
                    System.out.printf("The minimum number in this file is -> %d \n", min);
                    double median = operation.medianOfNumbers(new ArrayList<>(numbers));
                    System.out.printf("The median of numbers in this file is -> %.2f \n", median);
                    double avg = operation.avgOfNumbers(numbers);
                    double roundedAvg = Math.round(avg);
                    System.out.printf("The average of all numbers in this file is -> %.2f \n", roundedAvg);
                    List<Integer> maxSeqIncrease = operation.largerSequenceIncrease(numbers);
                    StringBuilder number1 = new StringBuilder();
                    for (Integer num : maxSeqIncrease) {
                        number1.append(num).append(" ");
                    }
                    System.out.printf("The largest sequence of numbers that increases is -> %s \n", number1);
                    List<Integer> maxSeqDegrease = operation.largerSequenceDegrease(numbers);
                    StringBuilder number2 = new StringBuilder();
                    for (Integer num : maxSeqDegrease) {
                        number2.append(num).append(" ");
                    }
                    System.out.printf("The largest sequence of numbers that degrees is -> %s \n", number2);
                    System.out.println("-----------------------------------------------------------------------------");
                }
                case 2 -> {
                    int max = operation.maxOfNumbers(numbers);
                    System.out.printf("The maximum number in  this file is -> %d \n\n", max);
                }
                case 3 -> {
                    int min = operation.minOfNumbers(numbers);
                    System.out.printf("The minimum number in this file is -> %d \n\n", min);
                }
                case 4 -> {
                    double median = operation.medianOfNumbers(new ArrayList<>(numbers));
                    System.out.printf("The median of numbers in this file is -> %.2f \n\n", median);
                }
                case 5 -> {
                    double avg = operation.avgOfNumbers(numbers);
                    double roundedAvg = Math.round(avg);
                    System.out.printf("The average of all numbers in this file is -> %.2f \n\n", roundedAvg);
                }
                case 6 -> {
                    List<Integer> maxSeqIncrease = operation.largerSequenceIncrease(numbers);
                    StringBuilder number = new StringBuilder();
                    for (Integer num : maxSeqIncrease) {
                        number.append(num).append(" ");
                    }
                    System.out.printf("The largest sequence of numbers that increases is -> %s \n\n", number);
                }
                case 7 -> {
                    List<Integer> maxSeqDegrease = operation.largerSequenceDegrease(numbers);
                    StringBuilder number = new StringBuilder();
                    for (Integer num : maxSeqDegrease) {
                        number.append(num).append(" ");
                    }
                    System.out.printf("The largest sequence of numbers that degrees is -> %s \n\n", number);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice.get(key));
            }
        }
        scanner.close();
    }

    // A helper method to get the path to the desired file
    private static String getPath(Scanner scanner) {
        return scanner.nextLine().trim();
    }

    // A helper method to get list of available functions
    private static Map<Integer, String> getListOfChoice() {
        return new TreeMap<>(Map.of(
                1, "You can find all of these six quantities. For this please enter 1. \n Or you can do it separately by choosing appropriate number below\n",
                2, "Find the maximum number in the file",
                3, "Find the minimum number in the file",
                4, "FInd median",
                5, "FInd average of number in the file",
                6, "Find out the largest sequence of numbers (that follow one another) that increases",
                7, "Find out the largest sequence of numbers (that follow one another) that is decreasing",
                8, "Exit \n"
        ));
    }
}