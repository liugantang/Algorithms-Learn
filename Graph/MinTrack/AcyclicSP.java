package Graph.MinTrack;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;

        Topological top = new Topological(G);

        for (int v : top.TopoOrder())
        {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] > e.weight() + distTo[v])
            {
                distTo[w] = e.weight() + distTo[v];
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v)
    {
        return distTo[v];
    }

    public boolean hasPathTo(int v)
    {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v)
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

}
