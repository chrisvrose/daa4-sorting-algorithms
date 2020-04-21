package com.chris.daa4sorts;

import java.util.Comparator;
import java.util.List;

//import java.util.Comparator;

public abstract class GenericSort<T> implements Sorter<T>{
    /**
     * A set of elements to use. Is used directly for simpler sorts, or written to later.
     */
    protected List<T> elements;
    public List<T> getElements(){
        return elements;
    }

    /**
     * A comparator. Used to either sort, or to decide if the final array
     */
    protected Comparator<T> comparator;
    /**
     * Count
     */
    protected long count;
    


    /**
     * @return Whether the final list has been sorted or not
     */
    public boolean isSorted(){
        int length = elements.size();
        for(int i=0;i<length-1;i++){
            if(comparator.compare(elements.get(i),elements.get(i+1))>0){
                return false;
            }
        }
        return true;
 
 
    }
    /**
     * @return Get a count of number of computations done.
     * (Eg. Comparisons for comparison sorts)
     */
    public long getCount(){return count;}
}