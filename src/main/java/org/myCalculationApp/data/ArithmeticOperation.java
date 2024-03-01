package org.myCalculationApp.data;

import java.util.*;

/**
 * @see Functions
 */
public class ArithmeticOperation implements Functions {

    /**
     * This method return us the maximum number in the file;
     *
     * @param numbers - numbers of numbers we got from file
     * @return maximum number in the file
     */
    @Override
    public Integer maxOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare).orElseThrow(NoSuchElementException::new);
    }

    /**
     * This method return us the minimum number in the file;
     *
     * @param numbers - list of numbers we got from file
     * @return minimum number in the file
     */
    @Override
    public Integer minOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .min(Integer::compare).orElseThrow(NoSuchElementException::new);
    }

    /**
     * This method return the median of numbers
     *
     * @param numbers  integers we got from file
     * @return median which was got from file of integer numbers
     */
    @Override
    public Double medianOfNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        double median;

        if (numbers.size() % 2 == 0) {
            int middleIndex = (numbers.size() / 2) - 1;
            median = (0.5 * (numbers.get(middleIndex) + numbers.get(middleIndex + 1)));
        } else {
            int middleIndex = (numbers.size() / 2);
            median = numbers.get(middleIndex);
        }
        return median;
    }

    /**
     * This method return the average
     *
     * @param numbers - list of numbers we got from file
     * @return  average of elements
     */
    @Override
    public Double avgOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(v -> v)
                .average().orElseThrow(NoSuchElementException::new);
    }

    /**
     * This method return the largest sequence of numbers (that follow one another) that increase
     *
     * @param numbers - list of numbers we got from file
     * @return  sequence of elements
     */
    @Override
    public List<Integer> largerSequenceIncrease(List<Integer> numbers) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> templist = new ArrayList<>();
        int i = 0;
        int maxKey = 0;
        templist.add(numbers.get(i));

        while (i < numbers.size() - 1) {
            if (numbers.get(i + 1) > numbers.get(i)) {
                templist.add(numbers.get(i + 1));
                i++;
            } else {
                map.put(templist.size(), new ArrayList<>(templist));
                templist.clear();
                i++;
                templist.add(numbers.get(i));
            }
            map.put(templist.size(), new ArrayList<>(templist));
        }

        for (Integer n : map.keySet()) {
            if (n > maxKey) {
                maxKey = n;
            }
        }

        return map.get(maxKey);
    }

    /**
     * This method return the largest sequence of numbers (that follow one another) that degrease
     *
     * @param numbers - list of numbers we got from file
     * @return sequence of elements
     */
    @Override
    public List<Integer> largerSequenceDegrease(List<Integer> numbers) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> templist = new ArrayList<>();
        int i = 0;
        int maxKey = 0;
        templist.add(numbers.get(i));

        while (i < numbers.size() - 1) {
            if (numbers.get(i + 1) < numbers.get(i)) {
                templist.add(numbers.get(i + 1));
                i++;
            } else {
                map.put(templist.size(), new ArrayList<>(templist));
                templist.clear();
                i++;
                templist.add(numbers.get(i));
            }
            map.put(templist.size(), new ArrayList<>(templist));
        }

        for (Integer n : map.keySet()) {
            if (n > maxKey) {
                maxKey = n;
            }
        }

        return map.get(maxKey);
    }
}
