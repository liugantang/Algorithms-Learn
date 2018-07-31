package Find.ST;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private Value[] values;
    private Key[] keys;
    private int N;
    private int capacity;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        this.capacity = capacity;

    }

    private void resize(int M)
    {
        Key[] elements = (Key[]) new Comparable[M];
        Value[] elements2 = (Value[]) new Object[M];
        for (int i = 0; i < N; i++)
        {
            elements[i] = keys[i];
            elements2[i] = values[i];
        }

        keys = elements;
        values = elements2;
        capacity = M;
    }
    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    //取得小于key的键的数量
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) {
                lo = mid + 1;

            } else if (cmp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return lo;//若没有找到key；
    }

    public void put(Key key, Value value) {
        if (N > capacity/4)
        {
            resize(N*4);

        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        N++;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key celing(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return keys[i];
        } else if (i == 0) {
            return null;
        } else {
            return keys[i - 1];

        }
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        int i = rank(key);


        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }


        for (int j = i; j < N - 1; j++) {
            values[j] = values[j + 1];
            keys[j] = keys[j + 1];
        }

        N--;
        keys[N] = null;
        values[N] = null;

    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();

        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }

        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }

        return q;
    }

    public boolean contains(Key hi) {
        return get(hi) != null;
    }
}
