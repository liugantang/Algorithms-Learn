package Graph.MinTrack;

import edu.princeton.cs.algs4.Stack;

public class SP {
    double distTo[];
    DirectedEdge edgeTo[];
    private PriorityQueue pq;

    SP(EdgeWeightDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new PriorityQueue(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }

    }

    double distTo(int v) //从顶点s到v的距离，如果不存在则路径为无穷大
    {
        return distTo[v];
    }

    boolean hasPathTo(int v) //是否存在从顶点s到v的路径
    {
        return distTo[v] < Double.POSITIVE_INFINITY;

    }

    Iterable<DirectedEdge> pathTo(int v) //从顶点s到v的路径，如果不存在则为null
    {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        return path;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    private void relax(EdgeWeightDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) { //这里十分重要，通过这两行代码，实现了一个这样的功能，就是得到到目标顶点的最短距离
                distTo[w] = distTo[v] + e.weight();
                if (pq.contain(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
                edgeTo[w] = e;
            }

        }
    }
}
