package Graph.NoGuideGraph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Paths {
    private boolean marked[];
    private int[] edgeTo;
    private final int s;

    //在g中找出所有起点为s的路径
    Paths(Graph g, int s)
    {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;

        for (int w : g.adj(v))
        {
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    //是否存在从s到v的路径
    boolean hasPathToV(int v)
    {
        return marked[v];
    }

    //s到v的路径，如果不存在就返回null
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathToV(v))
        {
            return null;
        }

        edu.princeton.cs.algs4.Stack<Integer> path = new edu.princeton.cs.algs4.Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);


        return path;
    }
}
