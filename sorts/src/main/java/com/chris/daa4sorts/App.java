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

    static String menu = "1. Menu\n2. Create element array\n3. Select Sorting algorithm\n4. Sort\n0. Exit";
    static String sort = "1.Insertion\n2.Merge\n3.Tree\n4.Radix Base n";

    public static void main(String[] args) {
        ArrayList<Integer> list = null;
        int choice = 0, i, x, y;
        Sorter<Integer> sorter = null;
        Scanner in = new Scanner(System.in);

        while ((choice = in.nextInt()) != 0) {
            switch (choice) {
                case 0:
                    break;
                case 1:
                    sop(menu);
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
                    break;
                case 3:
                    try {
                        if (list == null) {
                            throw new Exception("Did not initialize list");
                        }
                        sop(sort);
                        x = in.nextInt();
                        switch (x) {
                            case 1:
                                sop("Insertion sort");
                                sorter = new InsertionSort<>(list, (a, b) -> a - b);
                            case 2:
                                sop("Merge Sort");
                                sorter = new MergeSort<Integer>(list, (a, b) -> a - b);
                            case 3:
                                sop("Tree Sort");
                                sorter = new TreeSort(list);
                                break;
                            case 4:
                                sop("Radix MSD Base N");
                                sop("Base N=?");
                                y = in.nextInt();
                                sorter = new RadixSort(list, y);
                                break;
                            default:
                                throw new Exception("Invalid Option for sorting");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        sop("Enter menu option again:");
                    }
                    break;
                case 4:
                    try {
                        if (sort == null) {
                            throw new Exception("No sorting algo selected");
                        }
                        sorter.sort();
                        // our initial list got sorted, as java passes these by reference
                        sop("List:");
                        sop(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
                        sop("Count:" + sorter.getCount());
                    } catch (Exception e) {
                        e.printStackTrace();
                        sop("Enter menu option again:");
                    }
                    break;
                default:
                    sop("Invalid choice");

            }
        }

        in.close();
    }
}
