package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixNumber {
    public List<Integer> convertMatrixNumToList(Integer[][] numbers) {
       return Arrays.stream(numbers)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
