package Graph.MinTrack;

//对于有向加权图的拓扑排序
import edu.princeton.cs.algs4.Stack;

public class Topological {
    private Stack<Integer> order;
    private boolean marked[];
    Topological(EdgeWeightDigraph G)
    {
        order = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++)
        {
            if (!marked[i])
            {
                dfs(G, i);
            }
        }
    }

    private void dfs(EdgeWeightDigraph G, int i)
    {
        marked[i] = true;

        for (DirectedEdge  e : G.adj(i))
        {
            if (!marked[e.to()])
            {
                dfs(G, e.to());
            }
        }
        order.push(i);
    }
    public Iterable<Integer> TopoOrder()
    {
        return order;
    }
}
