package Graph.MinTrack;

import Graph.NoGuideGraph.Bag;

import java.util.Scanner;

public class EdgeWeightDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightDigraph(Scanner input)
    {
        this(input.nextInt());
        int e = input.nextInt();
        for (int i = 0; i < e; i++)
        {
            DirectedEdge edge = new DirectedEdge(input.nextInt(), input.nextInt(), input.nextDouble());
            addEdge(edge);
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

    public void addEdge(DirectedEdge edge)
    {
        adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v)
    {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++)
        {
            for (DirectedEdge e : adj[v])
            {
                bag.add(e);
            }
        }

        return bag;
    }
}
