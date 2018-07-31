package Sort.QuickSort;

import Sort.ShellSort.Shell;

public class Quick3Way {
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

        int left = lo, i = lo + 1, right = hi;
        Comparable v = a[lo];
        while (i <= right)
        {
            int cmp = a[i].compareTo(v);

            if (cmp < 0)
            {
                Shell.exch(a, left, i);
                left++;
                i++;

            }
            else if (cmp == 0)
            {
                i++;
            }
            else
            {
                Shell.exch(a, right, i);
                right--;

            }
        }

        sort(a, lo, left-1);
        sort(a, right+1, hi);
    }
}
