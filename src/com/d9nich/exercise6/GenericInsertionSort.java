package com.d9nich.exercise6;

import java.util.Comparator;

public class GenericInsertionSort {
    public static <E extends Comparable<E>> void insertionSort
            (E[] list) {
        for (int i = 1; i < list.length; i++) {
            /* Insert list[i] into a sorted sublist list[0..i−1] so that
             list[0..i] is sorted. */
            E currentElement = list[i];
            int k;
            for (k = i - 1;
                 k >= 0 && list[k].compareTo(currentElement) > 0;
                 k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
    }

    public static <E> void insertionSort(E[] list,
                                         Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            /* Insert list[i] into a sorted sublist list[0..i−1] so that
             list[0..i] is sorted. */
            E currentElement = list[i];
            int k;
            for (k = i - 1;
                 k >= 0 && comparator.compare(list[k], currentElement) > 0;
                 k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
    }
}
