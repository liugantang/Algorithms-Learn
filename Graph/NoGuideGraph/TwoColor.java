//双色问题（二分图）
package Graph.NoGuideGraph;

public class TwoColor {
    private boolean marked[];
    private boolean color[];
    private boolean isTwoColorable = true;

    public TwoColor(Graph g)
    {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++)
        {
            if (!marked[s])
            {
                dfs(g, s);
            }
        }

    }
    //解决双色问题的原理，在dfs运行时对于两两连通且其中一个未做过标记的两个节点设置为相反的值，之后如果检查到两两连通都做过标记但节点值相同的
    // 两个节点则可以判定这个图不是二分图
    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        for (int w : g.adj(v))
        {
            if (!marked[w])
            {
                color[w] = !color[v];
                dfs(g, w);
            }
            else if (color[w] == color[v])
            {
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }
}
