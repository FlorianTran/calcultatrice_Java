package org.example;

public class SortAlgo {
    private int[] array;

    public SortAlgo(
            int[] array
    ) {
        this.array = array;
    }

    public int[] sort() {
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j< array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }
}
