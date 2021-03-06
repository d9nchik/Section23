package com.d9nich.exercise4;

import java.util.Arrays;

public class ImprovedQuickSort {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    public static int partition(int[] list, int first, int last) {
        int pivotIndex = pivotIndex(list, first, last);
        int pivot = list[pivotIndex]; // Choose the first element as the pivot
        int low = first; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > pivotIndex && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[pivotIndex] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return pivotIndex;
        }
    }

    private static int pivotIndex(int[] list, int first, int last) {
        int firstNumber = list[first];
        int lastNumber = list[last];
        int middle = (first + last) / 2;
        int[] numbersSorted = {firstNumber, lastNumber, list[middle]};
        Arrays.sort(numbersSorted);
        if (firstNumber == numbersSorted[1])
            return first;
        if (lastNumber == numbersSorted[1])
            return last;
        return middle;
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int value : list) System.out.print(value + " ");
    }
}
