package Graph.NoGuideGraph;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    //预处理构造函数
    public CC(Graph g)
    {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int s = 0; s < g.V(); s++)
        {
            if (!marked[s])
            {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Graph g, int s)
    {
        marked[s] = true;
        id[s] = count;

        for (int v : g.adj(s))
        {
            if (!marked[v])
            {
                dfs(g, v);
            }
        }
    }
    //v和w连通吗
    boolean connected(int v, int w)
    {
        return id[v] == id[w];
    }
    //连通分量数
    int count()
    {
        return count;
    }
    //v所在的连通分量的标示符（0～count（）-1）
    int id(int v)
    {
        return id[v];
    }
}
