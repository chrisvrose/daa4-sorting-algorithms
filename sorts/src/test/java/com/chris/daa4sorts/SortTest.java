package com.chris.daa4sorts;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SortTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(53);
        list.add(343);
        list.add(56);

        ArrayList<Sorter<Integer>> sorts = new ArrayList<Sorter<Integer>>();
        sorts.add(new RadixSort(list, 10));
        sorts.add(new InsertionSort<Integer>(list, (a, b) -> a - b));
        sorts.add(new MergeSort<Integer>(list, (a, b) -> a - b));
        for (Sorter<Integer> sorter : sorts) {
            sorter.sort();
            assertTrue(sorter.isSorted());
            Assert.assertNotNull(sorter.getCount());
        }
    }
}