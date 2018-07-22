package Sort.ShellSort;

import Sort.MergeSort.Merge;
import Sort.MergeSort.MergeBu;
import Sort.QuickSort.Quick;

import java.util.Arrays;
import java.util.Random;

public class RandTest {
    public static void randTest()
    {
        Random random = new Random();
        Comparable<Integer>[] array = new Comparable[1000000];

        for (int i = 0; i < 1000000; i++)
        {
            array[i] = random.nextInt(1000000);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();

        Quick.sort(array);

        System.out.println(Arrays.toString(array));
        System.out.println(ShellSortPractice.checkSort(array));
    }
}
