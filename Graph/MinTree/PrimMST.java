package Graph.MinTree;


import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

import java.math.BigDecimal;

public class PrimMST {
    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //distTo[w] = edgeTo[w].weight()
    private boolean[] marked; //如果v在树中则为其true
    private IndexMinPQ<Double> pq; //有效的横切边

    public PrimMST(EdgeWeightGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0); //用顶点0与权重0初始化pq

        while (!pq.isEmpty()) {
            visit(G, pq.delMin());  //将最近的顶点添加到树中
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v] = true;

        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue; //v-w失效
            }
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<>();
        for (Edge e : edgeTo)
        {
            if (e != null)
            {
                mst.enqueue(e);
            }
        }
        return mst;
    }


    public double weight() {
        double weight = 0.0;
        for (Edge e : edges()) {
            BigDecimal b1 = new BigDecimal(Double.toString(weight));
            BigDecimal b2 = new BigDecimal(Double.toString(e.weight()));
            weight = b1.add(b2).doubleValue();
        }
        return weight;
    }

}
