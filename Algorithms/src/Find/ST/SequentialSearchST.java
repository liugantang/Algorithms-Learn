package Find.ST;

public class SequentialSearchST <Key extends Comparable<Key>, Value extends Comparable<Value>>{
    private class Node
    {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;
    private int size = 0;

    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
            {
                return x.value;
            }
        }

        return null;
    }

    public void put(Key key, Value value)
    {
        if (value != null)
        {
            size++;
        }
        for (Node x = first; x != null; x = x.next)
        {

            if (key.equals(x.key))
            {
                x.value = value;
                return;
            }


        }

        first = new Node(key, value, first);
    }

    public void delete(Key key)
    {
        put(key, null);
    }

    public boolean contain(Key key)
    {
        return get(key) != null;
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    int getSize()
    {
        return size;
    }


}
