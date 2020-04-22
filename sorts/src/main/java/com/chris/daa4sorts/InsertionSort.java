package com.chris.daa4sorts;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort<T> extends GenericSort<T> {

    public InsertionSort(ArrayList<T> elements, Comparator<T> comparator) {
        this.elements = elements;
        this.comparator = comparator;
        count = 0;
    }

    public void sort() {
        int size = elements.size();
        for (int i = 1; i < size; ++i) {
            T key = elements.get(i);
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */
            count++;
            while (j >= 0 &&  comparator.compare(elements.get(j), key)>0) {
                elements.set(j+1,elements.get(j));
                this.count++;
                j--;
            }
            elements.set(j+1, key);
        }

        //done
    }

    public long getCount() {
        return this.count;
    }

}