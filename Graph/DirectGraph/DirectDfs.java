package Graph.DirectGraph;

public class DirectDfs {
    private boolean marked[];

    //在G中找到从s可达的所有顶点
    public DirectDfs(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    //在G中找到从source中的所有顶点可达的所有顶点
    public DirectDfs(Digraph G, Iterable<Integer> source)
    {
        marked = new boolean[G.V()];
        for (int w : source)
        {
            if (!marked[w])
            {
                dfs(G, w);
            }
        }
    }
    //v是可达的么?
    boolean marked(int v)
    {
        return marked[v];
    }

    private void dfs(Digraph G, int s)
    {
        marked[s] = true;

        for (int w : G.adj(s))
        {
            if (!marked[w])
            {
                dfs(G, w);
            }

        }
    }
}
