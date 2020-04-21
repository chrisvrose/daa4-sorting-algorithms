package com.chris.daa4sorts;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class RadixSortTest {
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

        RadixSort sorter =new RadixSort(list, 10) ;
        sorter.sort();
        assertTrue(sorter.isSorted());
        Assert.assertNotNull(sorter.getCount());
    }
}
