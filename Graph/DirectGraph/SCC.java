package Graph.DirectGraph;

public class SCC {
    private boolean[] marked;
    private int id[];
    private int count;

    public SCC(Digraph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s : order.reversPost())
        {
            if (!marked[s])
            {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int s)
    {
        marked[s] = true;
        id[s] = count;
        for (int w : G.adj(s))
        {
            if (!marked[w])
            {
                dfs(G, w);
            }
        }
    }
    //v和w是强连通分量吗？
    boolean StronglyConncted(int v, int w)
    {
        return id[v] == id[w];
    }
    //图中强连通分量的个数
    int count()
    {
        return count;
    }
    //v所在的强连通分量的标识符（在0～count（）-1之间）
    int id(int v)
    {
        return id[v];
    }
}
