package com.d9nich.exercise20;

import java.util.Arrays;

public class MergeSort {
    /**
     * The method for sorting the numbers
     */
    public static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length);
    }

    public static void mergeSort(int[] list, int start, int finish) {
        if (finish - start > 1) {
            // Merge sort the first half
            int medium = (start + finish) / 2;
            mergeSort(list, start, medium);

            // Merge sort the second half
            mergeSort(list, medium, finish);

            // Merge firstHalf with secondHalf into list
            merge(list, start, medium, finish);
        }
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(int[] list, int start, int medium, int end) {
        int[] list1 = Arrays.copyOfRange(list, start, medium);
        int[] list2 = Arrays.copyOfRange(list, medium, end);
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = start; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                list[current3++] = list1[current1++];
            else
                list[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            list[current3++] = list1[current1++];

        while (current2 < list2.length)
            list[current3++] = list2[current2++];
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for (int value : list) System.out.print(value + " ");
    }
}
