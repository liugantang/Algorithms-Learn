package Graph.NoGuideGraph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N)
        {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null)
        {
            return 0;

        }
        else
        {
            return x.N;
        }
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null)
        {
            return null;

        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
            return get(x.left, key);

        }
        else if (cmp > 0)
        {
            return get(x.right, key);
        }
        else
        {
            return x.value;
        }
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null)
        {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
            x.left = put(x.left, key, value);
        }
        else if (cmp > 0)
        {
            x.right = put(x.right, key, value);
        }
        else
        {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public boolean contain(Key key)
    {
        return contain(root, key);
    }

    private boolean contain(Node x, Key key)
    {
        if (x == null)
        {
            return false;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
            contain(x.left, key);
        }
        else if (cmp > 0)
        {
            contain(x.right, key);
        }
        else if (cmp == 0)
        {
            return true;
        }

        return false;
    }
    public Key min()
    {
        return min(root).key;
    }

    private Node min(Node x)
    {
        if (x.left == null)
        {
            return x;
        }

        return min(x.left);
    }

    public Key max()
    {
        return max(root).key;
    }

    private Node max(Node x)
    {
        if (x.right == null)
        {
            return x;
        }
        return max(x.right);
    }
    public Iterable<Key> keys()
    {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new LinkedBlockingQueue<>();
        keys(root, queue, lo, hi);

        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null)
        {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
        {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0)
        {
            queue.add(x.key);
        }
        if (cmphi > 0)
        {
            keys(x.right, queue, lo, hi);
        }
    }

}
