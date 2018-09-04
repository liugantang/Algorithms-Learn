package Graph.DirectGraph;

public class Topological {
    private Iterable<Integer> order;
    //构造函数
    public Topological(Digraph G)
    {
        DirectCircle cycleFinder = new DirectCircle(G);
        if (!cycleFinder.hasCircle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversPost();
        }
    }
    //G是有向无环图吗?
    boolean isDAG()
    {
        return order != null;
    }
    //拓扑排序的所有顶点
    Iterable<Integer> order()
    {
        return order;
    }
}
