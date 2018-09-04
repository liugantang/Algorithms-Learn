package Graph.DirectGraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BfsPath {
    private boolean marked[];
    private int route[];
    private final int s;

    public BfsPath(Digraph G, int s)
    {
        this.s = s;
        marked = new boolean[G.V()];
        route = new int[G.V()];

        bfs(G, s);
    }

    private void bfs(Digraph G, int s)
    {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();

            for (int w : G.adj(v))
            {
                if (!marked[w])
                {
                    marked[w] = true;
                    route[w] = v;
                    queue.enqueue(w);
                }

            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> route(int v)
    {
        if (!hasPathTo(v))
        {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s; w = route[w])
        {
            stack.push(w);
        }

        stack.push(s);

        return stack;
    }


}
