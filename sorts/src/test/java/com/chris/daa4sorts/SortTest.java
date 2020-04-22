package com.chris.daa4sorts;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.AssertionFailedError;

/**
 * Unit test for simple App.
 */
public class SortTest {

    /**
     * Prepare a reverse Sorted Array
     * @param num
     * @return
     */
    ArrayList<Integer> prepareList(int num){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=num;i>0;i--) list.add(i);
        return list;
    }

    void testSort(Sorter<Integer> sorter,int num) throws AssertionFailedError,AssertionError{
        sorter.sort();
        assertTrue(sorter.isSorted());
        Assert.assertNotNull(sorter.getCount());
        List<Integer> list = sorter.getElements();
        for(int i=1;i<=num;i++){
            assertTrue(i==list.get(i-1));
        }
    }

    /**
     * Test Radix Sort
     */
    @Test
    public void testRadix() {
        testSort(new RadixSort(prepareList(1000), 10),1000);
    }


    @Test
    public void testInsertion(){
        testSort(new InsertionSort<Integer>(prepareList(1000), (a,b)->a-b),1000);
    }

    @Test
    public void testTree(){
        testSort(new TreeSort(prepareList(1000)),1000);
    }

    @Test
    public void testMerge(){
        testSort(new MergeSort<Integer>(prepareList(1000), (a,b)->a-b),1000);
    }
}
