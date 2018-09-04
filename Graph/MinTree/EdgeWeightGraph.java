package Graph.MinTree;

import Graph.NoGuideGraph.Bag;

import java.util.Scanner;

public class EdgeWeightGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightGraph(int v)
    {
        this.V = v;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < v; i++)
        {
            adj[i] = new Bag<Edge>();
        }
    }

    public EdgeWeightGraph(Scanner input)
    {
        this(input.nextInt());
        this.E = input.nextInt();
        while (input.hasNextInt())
        {
            int v = input.nextInt();
            int w = input.nextInt();
            double weight = input.nextDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v)
    {
        return adj[v];
    }

    public Iterable<Edge> edges()
    {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++)
        {
            for (Edge e : adj[v])
            {
                if (e.other(v) > v)//v从0开始，故所有比v小的顶点都已经被遍历过
                {
                    b.add(e);
                }
            }
        }

        return b;
    }
}
