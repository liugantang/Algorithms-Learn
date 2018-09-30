package Graph.MinTrack;

import edu.princeton.cs.algs4.Stack;

public class AcyclicLP {
    private double distTo[];
    private DirectedEdge edgeTo[];

    public AcyclicLP(EdgeWeightDigraph G, int s)
    {
        distTo = new double[G.V()];
        for (int i = 0; i < G.V(); i++)
        {
            distTo[i] = Double.NEGATIVE_INFINITY;
        }
        edgeTo = new DirectedEdge[G.E()];

        distTo[s] = 0;
        Topological topological = new Topological(G);

        for (int v : topological.TopoOrder())
        {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (e.weight() + distTo[v] > distTo[w])
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
