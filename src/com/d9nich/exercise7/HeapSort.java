package com.d9nich.exercise7;

public class HeapSort {
    /**
     * Heap sort method
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        MinHeap<E> heap = new MinHeap<>();

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
        heapSort(list);
        for (Integer integer : list) System.out.print(integer + " ");
    }
}
