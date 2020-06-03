package com.d9nich.exercise12;

import java.util.ArrayList;
import java.util.Random;

public class RadixSort {
    private static final int GENERATOR_RANGE = 1_000_000;

    @SuppressWarnings("unchecked")
    public static void bucketSort(int[] list) {
        final int MAX_NUMBER_OF_DIGIT = (int) Math.log10(GENERATOR_RANGE) + 1;
        int divider = 1;
        for (int m = 0; m < MAX_NUMBER_OF_DIGIT; m++) {
            ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[10];
// Distribute the elements from list to buckets
            for (int value : list) {
                int key = (value / divider) % 10; // Assume element has the getKey() method
                if (bucket[key] == null)
                    bucket[key] = new ArrayList<>();
                bucket[key].add(value);
            }
// Now move the elements from the buckets back to list
            int k = 0; // k is an index for list
            for (ArrayList<Integer> arrayList : bucket) {
                if (arrayList != null) {
                    for (Integer integer : arrayList) list[k++] = integer;
                }
            }
            divider *= 10;
        }
    }


    public static void main(String[] args) {
        int[] ints = new int[1_200_000];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(GENERATOR_RANGE);
        }
        bucketSort(ints);
    }
}
