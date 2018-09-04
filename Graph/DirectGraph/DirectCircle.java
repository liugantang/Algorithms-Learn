package Graph.DirectGraph;

import edu.princeton.cs.algs4.Stack;


public class DirectCircle {
    private boolean marked[];
    private int edgeTo[];
    private Stack<Integer> cycle;
    private boolean onStack[];

    //寻找有向环的构造工具
    DirectCircle(Digraph G)
    {
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int i = 0; i < G.V(); i++)
        {
            if (!marked[i])
            {
                dfs(G, i);
            }
        }
    }
    //G中是否含有有向环
    boolean hasCircle()
    {
        return cycle != null;
    }
    //有向环中的所有顶点(如果存在的话)
    Iterable<Integer> cycle()
    {
        return cycle;
    }
    //使用onStack[]标记已被访问过的节点,如果存在有向环,必定访问一个节点两次,这时就可以根据onStack[index]的值去判定
    private void dfs(Digraph G, int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (this.hasCircle())
            {
                return;
            }
            else if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
            }
        }
        //归位,防止干扰下一次查询
        onStack[v] = false;
    }
}
