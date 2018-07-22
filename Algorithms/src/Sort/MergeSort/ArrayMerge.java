package Sort.MergeSort;

import Sort.ShellSort.Shell;

import static Sort.ShellSort.Shell.less;
import  static Sort.ShellSort.Shell.exch;

public class ArrayMerge {
    public static void merge(Comparable[] a, int lo, int hi, int mid)
    {
        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)
            {
                a[k] = aux[j++];
            }
            else if (j > hi)
            {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i]))
            {
                a[k] = aux[j++];
            }
            else
            {
                a[k] = aux[i++];
            }
        }
    }
}
