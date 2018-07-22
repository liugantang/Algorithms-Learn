package Sort.MergeSort;

import Sort.ShellSort.Shell;

public class MergeBu {
    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz = sz + sz)
        {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz)
            {
                merge(a, lo, Math.min(a.length-1, lo+sz+sz-1), lo+sz-1);
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int hi, int mid)
    {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)
            {
                a[k] = aux[j++];
            }else if (j > hi)
            {
                a[k] = aux[i++];
            }
            else if (Shell.less(aux[j], aux[i]))
            {
                a[k] = aux[j++];
            }else
            {
                a[k] = aux[i++];
            }
        }
    }

}
