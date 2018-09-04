//无环图问题
package Graph.NoGuideGraph;

public class Circle {
    private boolean marked[];
    private boolean hasCircle;

    public Circle(Graph G)
    {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
        {
            if (!marked[s])
            {
                dfs(G,s,s);
            }
        }
    }

    //这个算法的原理是如果图G中有环，那么必有一个顶点有两个或两个以上的连通顶点
    private void dfs(Graph g, int u, int v) {
        marked[u] = true;

        for (int w : g.adj(u))
        {
            if (!marked[w])
            {
                dfs(g, w, u);
            }
            //如果是无环图，那么w 必定等于 v，因为w只有一个连通顶点那就是v
            else if(w != v)
            {
                hasCircle = true;
            }

        }
    }

    public boolean hasCircle()
    {
        return hasCircle;
    }
}
