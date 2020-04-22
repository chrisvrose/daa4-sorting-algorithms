package com.chris.daa4sorts;

import java.util.List;

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
    long getCount();
    List<T> getElements();
}