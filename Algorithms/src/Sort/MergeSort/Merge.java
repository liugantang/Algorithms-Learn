package Sort.MergeSort;

import Sort.ShellSort.Shell;
import sun.util.resources.cldr.mer.CurrencyNames_mer;

public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        int lo = 0;
        int hi = a.length-1;
        aux = new Comparable[a.length];
        int mid = hi / 2;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a,int lo, int hi)
    {
        if (hi <= lo)
        {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, hi, mid);
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
            }else if (Shell.less(aux[j], aux[i]))
            {
                a[k] = aux[j++];
            }else
            {
                a[k] = aux[i++];
            }
        }
    }
}
