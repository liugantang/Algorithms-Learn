package Graph.NoGuideGraph;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraphTest {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/movies.txt";
        String delim = "/";

        SymbolGraph sg = new SymbolGraph(fileName, delim);
        Graph G = sg.G();
        while (StdIn.hasNextLine())
        {
            String source = StdIn.readLine();
            for (int w : G.adj(sg.index(source)))
            {
                StdOut.println(" " + sg.name(w));
            }
        }
    }
}
