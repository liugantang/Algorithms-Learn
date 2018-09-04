package Graph.NoGuideGraph;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class GraphDeal {
    public static int degree(Graph g, int v)
    {
        int degree = 0;
        for (int w : g.adj(v))
        {
            degree++;
        }

        return degree;
    }

    public static int maxDegree(Graph g)
    {
        int max = 0;
        for (int v = 0; v < g.V(); v++)
        {
            if (degree(g, v) > max)
            {
                max = degree(g, v);
            }
        }

        return max;
    }

    public static double avgDegree(Graph g)
    {
        return 2.0 * g.E() / g.V();
    }

    public static int numberOfSelfLoop(Graph g)
    {
        int count = 0;
        for (int v = 0; v < g.V(); v++)
        {
            for (int w : g.adj(v))
            {
                if (v == w)
                {
                    count++;
                }
            }
        }

        return count / 2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File tinyG = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt");
        Scanner input = new Scanner(tinyG);
        Graph g = new Graph(input);

        System.out.println(g.toString());
        System.out.println();
        System.out.println(degree(g, 9));
        System.out.println();
        System.out.println(avgDegree(g));
        System.out.println();
        System.out.println(maxDegree(g));
        System.out.println();
        System.out.println(numberOfSelfLoop(g));

    }
}
