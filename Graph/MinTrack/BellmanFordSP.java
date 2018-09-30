package Graph.MinTrack;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BellmanFordSP {
    private double[] distTo; //从起点到某个顶点的路径长度
    private DirectedEdge[] edgesTo; //从顶点到某一顶点的边
    private boolean[] onQ;//该顶点是否存在于队列中
    private Queue<Integer> queue;//正在被放松的顶点
    private int cost;//relax（）的调用次数
    private Iterable<DirectedEdge> cycle; //edgeTo[]中的是否有负权重环

    public BellmanFordSP(EdgeWeightDigraph G, int s) {
        distTo = new double[G.V()];
        edgesTo = new DirectedEdge[G.E()];
        onQ = new boolean[G.V()];
        queue = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;

        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[s] = false;
            relax(G, v);
        }

    }

    private void relax(EdgeWeightDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgesTo[w] = e;

                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }

            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgesTo[v]; e != null; e = edgesTo[e.from()]) {
            path.push(e);
        }

        return path;
    }

    //是否含有负权重环
    public boolean hasNegativeCycle() {
        return cycle != null;

    }

    private void findNegativeCycle() {
        int V = edgesTo.length;
        EdgeWeightDigraph spt = new EdgeWeightDigraph(V);
        for (int v = 0; v < V; v++) {
            if (edgesTo[v] != null) {
                spt.addEdge(edgesTo[v]);
            }
        }

        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(spt);
        cycle = cf.cycle();
    }
//得到负权重环
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }





}
