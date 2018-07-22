package Sort.MergeSort;

import Sort.ShellSort.RandTest;
import Sort.ShellSort.Shell;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPractice {
    public static void main(String[] args)
    {
        Comparable[] array = {10, 7, 5, 1, 3 ,4, 6, 4, 2, 0 };
        Merge.sort(array);
        System.out.println(Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        String judgeString = input.next();
        if (judgeString.equals("Y"))
        {
            RandTest.randTest();
        }
    }
}
