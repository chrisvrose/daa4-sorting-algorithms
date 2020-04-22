package com.chris.daa4sorts;

import java.util.ArrayList;
import java.util.Comparator;
//TODO FIX MERGESORT
public class MergeSort<T> extends GenericSort<T> {
    public MergeSort(ArrayList<T> elements, Comparator<T> comparator) {
        this.elements = elements;
        this.comparator = comparator;
    }

    /**
     * Sort by mergesort
     * 
     * @apiNote for mergeSort's recursive Sort
     */
    public void sort() {
        sort(0, elements.size() - 1);
    }

    /**
     * The internal sort function
     * 
     * @param l lower bound
     * @param h upper bound
     */
    protected void sort(int l, int h) {
        int m = (l + h) / 2;
        if (l < h) {
            sort(l, m);
            sort(m + 1, h);
            // System.out.println("("+l+','+m+","+h+")");
            merge(l, m, h);
        }
    }

    protected void merge(int l, int m, int h) {
        ArrayList<T> a1 = new ArrayList<T>();
        ArrayList<T> a2 = new ArrayList<T>();
        // copy
        for (int i = 0; i < m - l + 1; i++) {
            a1.add(elements.get(i + l));
        }
        for (int i = 0; i < h - m; i++) {
            a2.add(elements.get(m + 1 + i));
        }

        int i, j;
        // merge
        for (i = 0, j = 0; i < (m - l + 1) && j < (h - m);) {
            count++;
            if (comparator.compare(a1.get(i), a2.get(j)) < 0) {
                elements.set(i + j + l, a1.get(i));
                i++;
            } else {
                elements.set(i + j + l, a2.get(j));
                j++;
            }
        }
        while (i < (m - l + 1)) {
            elements.set(i + j + l, a1.get(i));
            i++;
            count++;
        }
        while (j < (h - m)) {
            elements.set(i + j + l, a2.get(j));
            j++;
            count++;
        }

    }
}