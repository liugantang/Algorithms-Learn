package Sort.QuickSort;

import Sort.MergeSort.ArrayMerge;
import Sort.ShellSort.ShellSortPractice;

import java.util.Arrays;
import java.util.Random;

public class Quick3WaySortPractice {
    public static void main(String[] args)
    {
        Random rand = new Random();
        Comparable[] a = {7, 9, 6, 5, 3, 6, 8, 3, 9, 0};

//        for (int i = 0; i < 10; i++)
//        {
//            a[i] = rand.nextInt(10);
//        }

        System.out.println(Arrays.toString(a));
        System.out.println();
        Quick3Way.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(ShellSortPractice.checkSort(a));

    }
}
