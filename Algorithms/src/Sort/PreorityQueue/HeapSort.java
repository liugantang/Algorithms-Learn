package Sort.PreorityQueue;


import java.util.Arrays;

public class HeapSort {
    public static void sort(Comparable[] a)
    {
        Comparable[] v = Trans(a);
        int N = v.length-1;
        for (int k = N / 2; k >= 1; k--)
        {
            sink(v, k, N);
        }

        while (N > 1)
        {
            exch(v, 1, N--);
            sink(v, 1, N);
        }

        System.out.println(Arrays.toString(v));

        for (int i = 1; i < v.length; i++)
        {
            a[i-1] = v[i];
        }
    }

    private static Comparable[] Trans(Comparable[] a) {
        int M = a.length + 1;
        Comparable[] v = new Comparable[M];
        for (int i = 0; i < a.length; i++)
        {
            v[i+1] = a[i];
        }


        return v;
    }


    private static void swim(Comparable[] a, int k)
    {
        while (k > 1)
        {
            if (less(a, k/2, k))
            {
                exch(a, k/2, k);
                k = k/2;
            }
        }
    }

    private static void sink(Comparable[] a, int k, int N)
    {
        while (k * 2 <= N)
        {
            int j = k * 2;

            if (j < N && less(a, j, j+1))
            {
                j++;
            }
            if (!less(a, k, j))
            {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }


    protected static boolean less(Comparable[] pq, int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    protected static void exch(Comparable[] pq, int i, int j)
    {
        Comparable v = pq[i];
        pq[i] = pq[j];
        pq[j] = v;
    }
}
