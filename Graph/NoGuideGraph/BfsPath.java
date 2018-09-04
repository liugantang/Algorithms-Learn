package Graph.NoGuideGraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
//广度优先搜索常用来解决最短路径问题
public class BfsPath {
    private boolean marked[];
    private int edgeTo[];
    private final int s;

    public BfsPath(Graph g, int s)
    {
        this.s = s;
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for (int w : g.adj(v))
            {
                if (!marked[w])
                {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
         if (!hasPathTo(v))
         {
             return null;
         }

         Stack<Integer> path = new Stack<>();
         for (int w = v; w != s; w = edgeTo[w])
         {
             path.push(w);
         }
         path.push(s);

         return path;
    }
}
