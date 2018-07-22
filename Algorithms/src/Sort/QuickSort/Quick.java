package Sort.QuickSort;

import Sort.ShellSort.Shell;

public class Quick {
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo)
        {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true)
        {
            while (Shell.less(a[++i], v))
            {
                if (i == hi)
                {
                    break;
                }
            }

            while (Shell.less(v, a[--j]))
            {
                if (j == lo)
                {
                    break;
                }
            }

            if (i >= j)
            {
                break;
            }

            Shell.exch(a, i, j);
        }

        Shell.exch(a, lo, j);


        return j;
    }
}
