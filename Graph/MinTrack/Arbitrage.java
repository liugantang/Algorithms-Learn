package Graph.MinTrack;

import edu.princeton.cs.algs4.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arbitrage {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTrack/rates.txt");
        Scanner input = new Scanner(data);
        int V = input.nextInt();
        String[] name = new String[V];
        EdgeWeightDigraph G = new EdgeWeightDigraph(V);

        for (int v = 0; v < V; v++)
        {
            name[v] = input.next();
            for (int w = 0; w < V; w++)
            {
                double rate = input.nextDouble();
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(e);
            }
        }

        BellmanFordSP spt = new BellmanFordSP(G, 0);
        if (spt.hasNegativeCycle())
        {
            double stake = 1000;
            for (DirectedEdge e : spt.negativeCycle())
            {
                System.out.format("%10.5f %s",stake, name[e.from()]);

                stake *= Math.exp(-e.weight());
                System.out.format("=%10.5f %s\n", stake, name[e.to()]);
            }
        }
        else
        {
            System.out.println("No arbitrage opportunity");
        }
    }
}
