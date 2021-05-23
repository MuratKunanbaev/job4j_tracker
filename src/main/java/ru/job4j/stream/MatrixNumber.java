package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixNumber {
    public List<Integer> convertMatrixNumToList(Integer[][] numbers) {
        List<List<Integer>> nums = Arrays.stream(numbers)
                .map(Arrays::asList)
                .collect(Collectors.toList());

       return nums.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
