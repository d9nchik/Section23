package com.d9nich.exercise9;

import com.d9nich.exercise5.HeapWithComparator;
import com.d9nich.exercise7.MinHeap;

import java.util.Comparator;

public class GenericHeapSort {
    public static <E extends Comparable<E>>
    void heapSort(E[] list){
        // Create a Heap of integers
        HeapWithComparator<E> heap = new HeapWithComparator<>();

        // Add elements to the heap
        for (E e : list) heap.add(e);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E> void heapSort(E[] list,
                                    Comparator<? super E> comparator){
        // Create a Heap of integers
        HeapWithComparator<E> heap = new HeapWithComparator<>(comparator);

        // Add elements to the heap
        for (E e : list) heap.add(e);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list, Comparator.reverseOrder());
        for (Integer integer : list) System.out.print(integer + " ");
    }
}
