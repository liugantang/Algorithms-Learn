package Graph.NoGuideGraph;

public class Search {
    private boolean[] marked;
    private int count;

    //找到与顶点s连通的所有顶点
    Search(Graph g, int s)
    {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        count++;
        for (int w : g.adj(v))
        {
            if ((!marked[w]))
            {
                dfs(g, w);
            }
        }
    }
    //v和s是连通的吗？
    boolean marked(int v)
    {
        return marked[v];
    }
    //与s连通的顶点总数
    int count()
    {
        return count;
    }

}
