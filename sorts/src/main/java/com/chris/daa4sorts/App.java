package com.chris.daa4sorts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Base menu-driven program
 *
 */
public class App {
    static void sop(String s) {
        System.out.println(s);
    }

    static String menu = "1. Menu\n2. Create element array\n3. Sort\n0. Exit";
    // static String sort = "1.Insertion\n2.Merge\n3.Tree\n4.Radix Base n";

    public static void main(String[] args) {
        ArrayList<Integer> list = null;
        int choice = 0, i, x;
        Scanner in = new Scanner(System.in);
        sop(menu);
        while ((choice = in.nextInt()) != 0) {
            switch (choice) {
                case 0:
                    break;
                case 1:
                    sop(menu);
                    break;
                case 2:
                    System.out.print("Current:");
                    if (list == null) {
                        sop("No list");
                    } else {
                        sop(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
                    }
                    list = new ArrayList<>();
                    sop("Enter number of elements");
                    x = in.nextInt();
                    sop("Enter elements");
                    for (i = 0; i < x; i++) {
                        list.add(in.nextInt());
                    }
                    sop("Enter menu option:");
                    break;
                case 3:
                    try {
                        if (list == null) {
                            throw new Exception("Did not set list yet");
                        }
                        ArrayList<Sorter<Integer>> sorters = new ArrayList<Sorter<Integer>>();
                        sop("Radix sort base n=?");
                        x = in.nextInt();
                        sorters.add(new InsertionSort<Integer>(new ArrayList<Integer>(list), (a, b) -> a - b));
                        sorters.add(new MergeSort<Integer>(new ArrayList<Integer>(list), (a, b) -> a - b));
                        sorters.add(new TreeSort(new ArrayList<Integer>(list)));
                        sorters.add(new RadixSort(new ArrayList<Integer>(list), x));
                        // sorters.add(new);
                        // our initial list got sorted, as java passes these by reference
                        sop("List:");
                        sop(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
                        sop("Sorting results");
                        for (Sorter<Integer> sorter : sorters) {
                            sorter.sort();
                            sop("Method:" + sorter.toString() + "\nSorted:" + (sorter.isSorted() ? "Yes" : "No")
                                    + "\tCount:" + sorter.getCount());
                            sop("Results: " + sorter.getElements().stream().map(String::valueOf)
                                    .collect(Collectors.joining(",")) + "\n");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                    } finally {
                        sop("Enter menu option:");
                    }
                    break;
                default:
                    sop("Invalid choice");

            }
        }

        in.close();
    }
}
