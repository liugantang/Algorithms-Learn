package Sort.QuickSort;

import Sort.ShellSort.RandTest;
import Sort.ShellSort.Shell;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortPractice {
    public static void main(String[] args)
    {
        Comparable[] array = {5, 7, 8, 4, 3, 1, 9};
        Quick.sort(array);
        System.out.println(Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        String judgeString = input.next();
        if (judgeString.equals("Y"))
        {
            RandTest.randTest();
        }
    }
}
