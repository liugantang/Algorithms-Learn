package Sort.MergeSort;

import java.util.Arrays;

public class ArrayMergeTest {
    public static void main(String[] args)
    {
        Comparable[] arrays = {1, 2, 3, 4, 2, 4, 5, 6};
        ArrayMerge.merge(arrays, 0, 7, 3);
        System.out.println(Arrays.toString(arrays));
    }
}
