package com.chris.daa4sorts;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.AssertionFailedError;

/**
 * Unit test for simple App.
 */
public class SortTest {
    final int num = 8192;
    /**
     * Prepare a sorted array
     * 
     * @param num
     * @return
     */
    ArrayList<Integer> prepareAscendingList(int num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num; i++)
            list.add(i);
        return list;
    }

    ArrayList<Integer> prepareRandomList(int num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num; i++)
            list.add(i);
        Collections.shuffle(list);
        return list;
    }

    /**
     * Prepare a reverse Sorted Array
     * 
     * @param num
     * @return
     */
    ArrayList<Integer> prepareDescendingList(int num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = num; i > 0; i--)
            list.add(i);
        return list;
    }

    /**
     * Tests, and returns value of count
     * 
     * @param sorter
     * @param num
     * @return Count of iterations in sort program
     * @throws AssertionFailedError
     * @throws AssertionError
     */
    long testSort(Sorter<Integer> sorter, int num) throws AssertionFailedError, AssertionError {
        sorter.sort();
        assertTrue(sorter.isSorted());
        Assert.assertNotNull(sorter.getCount());
        List<Integer> list = sorter.getElements();
        for (int i = 1; i <= num; i++) {
            assertTrue(i == list.get(i - 1));
        }
        return sorter.getCount();
    }

    /**
     * Test Radix Sort
     */
    @Test
    public void testRadix() {
        long asc, desc, rand;
        System.out.println("Radix LSD BASE 10");
        for (int i = 1; i <= num; i *= 2) {
            asc = testSort(new RadixSort(prepareAscendingList(i), 10), i);
            desc = testSort(new RadixSort(prepareDescendingList(i), 10), i);
            rand = testSort(new RadixSort(prepareRandomList(i), 10), i);
            System.out.println("S:" + i + "\tA:" + asc + "\tD:" + desc + "\tR:" + rand);
        }
    }

    @Test
    public void testInsertion() {
        long asc, desc, rand;
        System.out.println("Insertion Sort");
        for (int i = 1; i <= num; i *= 2) {
            asc = testSort(new InsertionSort<Integer>(prepareAscendingList(i), (a, b) -> a - b), i);
            desc = testSort(new InsertionSort<Integer>(prepareDescendingList(i), (a, b) -> a - b), i);
            rand = testSort(new InsertionSort<Integer>(prepareRandomList(i), (a, b) -> a - b), i);
            System.out.println("S:" + i + "\tA:" + asc + "\tD:" + desc + "\tR:" + rand);
        }
    }

    @Test
    public void testTree() {
        long asc, desc, rand;
        System.out.println("Tree Sort");
        for (int i = 1; i <= num; i *= 2) {
            asc = testSort(new TreeSort(prepareAscendingList(i)), i);
            desc = testSort(new TreeSort(prepareDescendingList(i)), i);
            rand = testSort(new TreeSort(prepareRandomList(i)), i);
            System.out.println("S:" + i + "\tA:" + asc + "\tD:" + desc + "\tR:" + rand);
        }
    }

    @Test
    public void testMerge() {
        long asc, desc, rand;
        System.out.println("Merge Sort");
        for (int i = 1; i <= num; i *= 2) {
            asc=testSort(new MergeSort<Integer>(prepareAscendingList(i), (a, b) -> a - b), i);
            desc=testSort(new MergeSort<Integer>(prepareDescendingList(i), (a, b) -> a - b), i);
            rand=testSort(new MergeSort<Integer>(prepareRandomList(i), (a, b) -> a - b), i);
            System.out.println("S:" + i + "\tA:" + asc + "\tD:" + desc + "\tR:" + rand);
        }
    }
}
