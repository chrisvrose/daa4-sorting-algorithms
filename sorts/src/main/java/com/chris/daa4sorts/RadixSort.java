package com.chris.daa4sorts;

import java.util.ArrayList;

public class RadixSort extends GenericSort<Integer> {
    protected int iterationsCount;
    protected int base;

    RadixSort(ArrayList<Integer> elements, int base) {
        this.elements = elements;
        this.base = base;
        this.comparator = (a, b) -> a - b;

        iterationsCount = elements.stream().reduce((a, b) -> {
            count++;
            return a > b ? a : b;
        }).orElse(1);
        iterationsCount = (int)Math.ceil(Math.log(iterationsCount)/Math.log(base))+1;
    }

    protected void countSort(int pos) {
        // ArrayList<Integer>[] buckets = new ArrayList<Integer>[10];
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        int key=0;
        // Setup the buckets
        for (int i = 0; i < base; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (Integer i : elements) {
            //add to bucket
            count++;
            key = (i/(int)Math.pow(base,pos-1))%base;
            buckets.get(key).add(i);
        }

        //clear the list, all info is in buckets
        elements.clear();
        //Now to extract
        for(ArrayList<Integer> lIntegers:buckets){
            /**
             * Using java, as addAll exists, and can use system functions for better performance
             */
            count+=lIntegers.size();
            elements.addAll(lIntegers);
        }

    }

    public void sort() {
        for(int i=1;i<=iterationsCount;i++){
            countSort(i);
        }
    }

    public String toString(){
        return "Radix Sort LSD Base "+this.base;
    }

}