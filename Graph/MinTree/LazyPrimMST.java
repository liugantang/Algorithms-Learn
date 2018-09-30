package Graph.MinTree;


import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
    private boolean marked[];//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边（包括失效的边）

    /*Prim算法
    从一点开始，收集所有与这一点连通的路径加入队列，取最小的一条加入最小生成树队列并在路径队列中删除该条边，并且标记这条边所连通的两个
    顶点，然后检查两个顶点是否有新的连通路径，如果有则加入路径存储队列，然后再从这个队列中取最小边加入生成树队列。如此循环，直到各顶点都标记完毕退出
    此时得到的生成树队列就是最小生成树队列
     */
    public LazyPrimMST(EdgeWeightGraph G)
    {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();
        visit(G, 0);
        while (!pq.isEmpty())
        {
            Edge e =  pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w])
            {
                continue;
            }
            mst.enqueue(e);
            if (!marked[v])
            {
                visit(G, v);
            }
            if (!marked[w])
            {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightGraph g, int i) {
        marked[i] = true;
        for (Edge e : g.adj(i))
        {
            if (!marked[e.other(i)])
            {
                pq.insert(e);
            }
        }
    }

    Iterable<Edge> edges()
    {
        return mst;
    }

    double weight()
    {
        double weight = 0;
        for (Edge e : mst)
        {
            weight += e.weight();
        }

        return weight;
    }
}
