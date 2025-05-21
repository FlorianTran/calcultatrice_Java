package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortAlgoTest {

    @Test
    public void testSort1() {
        int[] input = {5, 3, 8, 1, 4};
        int[] expected = {1, 3, 4, 5, 8};

        SortAlgo sorter = new SortAlgo(input);
        int[] result = sorter.sort();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSort2() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        SortAlgo sorter = new SortAlgo(input);
        int[] result = sorter.sort();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSort3() {
        int[] input = {4, 2, 2, 1, 3};
        int[] expected = {1, 2, 2, 3, 4};

        SortAlgo sorter = new SortAlgo(input);
        int[] result = sorter.sort();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSort4() {
        int[] input = {};
        int[] expected = {};

        SortAlgo sorter = new SortAlgo(input);
        int[] result = sorter.sort();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSort5() {
        int[] input = {42};
        int[] expected = {42};

        SortAlgo sorter = new SortAlgo(input);
        int[] result = sorter.sort();

        assertArrayEquals(expected, result);
    }
}
