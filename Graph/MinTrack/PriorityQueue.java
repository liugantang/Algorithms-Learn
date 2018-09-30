package Graph.MinTrack;

public class PriorityQueue {
    private int Key[];
    private double value[];
    private int N = 0;

    //    private int S = 0;
    public PriorityQueue(int N) {
        Key = new int[N + 1];
        for (int i = 0; i < Key.length; i++)
        {
            Key[i] = Integer.MAX_VALUE;
        }
        value = new double[N + 1];
    }

    public boolean contain(int w) {
        for (int i = 0; i < Key.length; i++) {
            if (Key[i] == w && Key[i] != Integer.MAX_VALUE) {
                return true;
            }
        }

        return false;
    }

    public void change(int key, double value) {
        for (int i = 0; i < Key.length; i++) {
            if (key == Key[i]) {
                this.value[i] = value;


                sink(i);
                swim(i);

            }
        }
    }

    public void insert(int key, double value) {
        N++;
        Key[N] = key;
        this.value[N] = value;
        swim(N);
    }

    public int delMin() {
        int min = Key[1];
        exch(1, N--);
        Key[N + 1] = Integer.MAX_VALUE;
        value[N + 1] = Double.POSITIVE_INFINITY;
        sink(1);
        return min;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        if (value[i] < value[j]) {
            return true;
        } else {
            return false;
        }
    }

    private void exch(int i, int j) {
        int KeyV = Key[i];
        double ValueV = value[i];

        Key[i] = Key[j];
        value[i] = value[j];
        Key[j] = KeyV;
        value[j] = ValueV;
    }

    private void swim(int k) {
        while (k > 1 && !less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && !less(j, j + 1)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
