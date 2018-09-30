package Graph.MinTrack;

import edu.princeton.cs.algs4.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TopologicTest {
    public static void main(String[] args) throws FileNotFoundException {
        File graphFile = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTrack/tinyEWDAG.txt");
        Scanner input = new Scanner(graphFile);

        EdgeWeightDigraph G = new EdgeWeightDigraph(input);
        Topological topological = new Topological(G);

        for (int i : topological.TopoOrder())
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
