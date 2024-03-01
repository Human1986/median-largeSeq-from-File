package org.myCalculationApp.data;

import java.util.List;

/**
 * Interface
 */
public interface Functions {

    /**
     * This method return us the maximum number in the file
     * @param numbers - list numbers from file
     * @return maximum number in the file
     */
    Integer maxOfNumbers(List<Integer> numbers);

    /**
     * This method return us the minimum number in the file
     * @param numbers - list numbers from file
     * @return maximum number in the file
     */
    Integer minOfNumbers(List<Integer> numbers);

    /**
     * This method return the median of numbers
     *
     * @param numbers  integers we got from file
     * @return median of numbers in the file
     */
    Double medianOfNumbers(List<Integer> numbers);

    /**
     * This method return the average
     *
     * @param numbers - list of numbers we got from file
     * @return  average of elements in the file
     */
    Double avgOfNumbers(List<Integer> numbers);

    /**
     * This method return the largest sequence of numbers (that follow one another) that increase
     *
     * @param numbers - list of numbers we got from file
     * @return  sequence of elements
     */
    List<Integer> largerSequenceIncrease(List<Integer> numbers);

    /**
     * This method return the largest sequence of numbers (that follow one another) that degrease
     *
     * @param numbers - list of numbers we got from file
     * @return sequence of elements
     */
    List<Integer> largerSequenceDegrease(List<Integer> numbers);

}
