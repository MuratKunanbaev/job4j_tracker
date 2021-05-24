package ru.job4j.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixNumberTest  {
    @Test
    public void whenArrayOf2By2() {
        Integer[][] matrix = new Integer[][] {
                {1, 2},
                {3, 4}
        };
        MatrixNumber matrixNumber = new MatrixNumber();
        List<Integer> rsl = matrixNumber.convertMatrixNumToList(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenArrayOf4By2() {
        Integer[][] matrix = new Integer[][] {
                {1, 2, 3, 4},
                {5, 6}
        };
        MatrixNumber matrixNumber = new MatrixNumber();
        List<Integer> rsl = matrixNumber.convertMatrixNumToList(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }

}