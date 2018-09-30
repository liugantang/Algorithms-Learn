package Graph.MinTrack;

import edu.princeton.cs.algs4.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EdgeWeightedCycleFinder {
    private boolean marked[];
    private boolean onStack[];
    private DirectedEdge edgeTo[];
    private Stack<DirectedEdge> cycle;
    public EdgeWeightedCycleFinder(EdgeWeightDigraph G)
    {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int i = 0; i < G.V(); i++)
        {
            if (!marked[i])
            {
                dfs(G, i);
            }
        }
    }

    public Iterable<DirectedEdge> cycle()
    {

        return cycle;
    }

    private boolean hasCircle()
    {
        return cycle != null;
    }


    private void dfs(EdgeWeightDigraph G, int v)
    {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (this.hasCircle())
            {
                return;
            }
            else if (!marked[w])
            {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w] == true)
            {
                cycle = new Stack<>();

                cycle.push(e);

                for (int x = v; x != w; x = edgeTo[x].from())
                {
                    cycle.push(edgeTo[x]);
                }

            }
        }

        onStack[v] = false;

    }

//A min program for test
    public static void main(String[] args) throws FileNotFoundException {
        Iterable<DirectedEdge> TestCycle;
        File data = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTrack/MyDirectCycleGraph.txt");
        Scanner input = new Scanner(data);

        EdgeWeightDigraph G = new EdgeWeightDigraph(input);
        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(G);
        TestCycle = cf.cycle();

        for (DirectedEdge e : TestCycle)
        {
            System.out.println(e);
        }
    }
}
