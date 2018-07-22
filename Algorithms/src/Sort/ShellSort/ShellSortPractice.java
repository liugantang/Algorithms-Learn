package Sort.ShellSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShellSortPractice {
    public static boolean checkSort(Comparable[] T)
    {
        for (int i = 1; i < T.length; i++)
        {
            if (T[i].compareTo(T[i - 1]) < 0)
            {
                return false;
            }

        }

        return true;
    }
    public static void main(String[] args)
    {
        Comparable[] array = {10, 7, 5, 1, 3 ,4, 6, 4, 2, 0 };
        Shell.sort(array);
        System.out.println(Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        String judgeString = input.next();
        if (judgeString.equals("Y"))
        {
            RandTest.randTest();
        }
    }
}
