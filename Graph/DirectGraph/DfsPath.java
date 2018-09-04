package Graph.DirectGraph;

import edu.princeton.cs.algs4.Stack;

public class DfsPath {
    private boolean marked[];
    private int route[];
    private final int s;

    DfsPath(Digraph G, int s)
    {
        this.s = s;
        marked = new boolean[G.V()];
        route = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int s)
    {
        marked[s] = true;

        for (int w : G.adj(s))
        {
            if (!marked[w])
            {
                route[w] = s;
                dfs(G, w);
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
