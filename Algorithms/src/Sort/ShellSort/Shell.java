package Sort.ShellSort;

public class Shell {
    public static void sort(Comparable[] T)
    {
        int N = T.length;
        int h = 1;
        while (h < N / 3)
        {
            h = h * 3 + 1;
        }

        while (h >= 1)
        {
            for (int i = h; i < N; i += h)
            {
                for (int j = i; j >= h; j -= h)
                {
                    if (less(T[j], T[j -h]))
                    {
                        exch(T, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }


    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    public static boolean less(Comparable i, Comparable j)
    {
        if (i.compareTo(j) > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
