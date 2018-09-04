package Graph.NoGuideGraph;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DegreeaOfSeparation {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/movies.txt";
        String sp = "/";
        SymbolGraph sg = new SymbolGraph(filename, sp);
        Graph G = sg.G();
        Scanner input = new Scanner(System.in);
        String source = input.nextLine();

        if (!sg.contain(source))
        {
            StdOut.println(source + " not in database ");
            return;
        }

        int s = sg.index(source);

        BfsPath bfs = new BfsPath(G, s);

        while (input.hasNextLine())
        {
            String sink = input.nextLine();

            if (sg.contain(sink))
            {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                {
                    for (int v : bfs.pathTo(t))
                    {
                        StdOut.println(" " + sg.name(v));

                    }
                }
                else
                {
                    StdOut.println("Not connected");
                }

            }
            else
            {
                StdOut.println("Not in database");
            }
        }
    }
}
