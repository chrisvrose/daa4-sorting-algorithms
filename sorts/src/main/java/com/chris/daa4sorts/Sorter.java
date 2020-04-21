package com.chris.daa4sorts;

public interface Sorter<T> {
    /**
     * Perform a sort
     */
    void sort();

    /**
     * Check if final result is sorted
     * @return
     */
    boolean isSorted();
}