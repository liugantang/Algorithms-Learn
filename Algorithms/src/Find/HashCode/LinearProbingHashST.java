package Find.HashCode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST()
    {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value)
    {
        if (N >= M / 2)
        {
            resize(2 * M);

        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1 ) % M)
        {
            if (keys[i].equals(key))
            {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    private void resize(int i) {
        Key nkeys[] = (Key[]) new Object[i];
        Value nvalues[] = (Value[]) new Object[i];
        for (int t = 0; t < keys.length; t++)
        {
            nkeys[t] = keys[t];
            nvalues[t] = values[t];
        }

        keys = nkeys;
        values = nvalues;
        M = i;

    }


    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
        {
            if (keys[i].equals(key))
            {
                return values[i];
            }
        }

        return null;
    }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new LinkedBlockingQueue<>();
        for (Key key : keys)
        {
            if (key != null)
            {
                queue.add((Key) (key + " " + String.valueOf(hash(key))));
            }

        }

        return queue;
    }
}
