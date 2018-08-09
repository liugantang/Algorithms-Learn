package Find.HashCode;


import Find.ST.SequentialSearchST;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SeparateChainingHashST <Key extends Comparable<Key>, Value extends Comparable<Value>> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST()
    {
    }

    public SeparateChainingHashST(int M)
    {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
        {
            st[i] = new SequentialSearchST<>();
        }

    }

    private int hash(Key key)
    {
        int i = key.hashCode();
        return (key.hashCode() & 0x7fffffff) % M;

    }

    public Value get(Key key)
    {
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key, Value value)
    {
        st[hash(key)].put(key, value);

    }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < M; i++)
        {
            Queue<Key> squeue = new LinkedBlockingQueue<>();
            squeue = (Queue<Key>) st[i].keys();

            for (Key addKey : squeue)
            {
                queue.add(addKey);
            }
        }
        return queue;
    }
}
