package Graph.NoGuideGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class BfsTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt");
        Scanner input = new Scanner(file);
        Scanner inputI = new Scanner(System.in);
        int s = inputI.nextInt();
        Graph g = new Graph(input);
        BfsPath search = new BfsPath(g, s);

        for (int v = 0; v < g.V(); v++)
        {

            if (search.hasPathTo(v))
            {
                System.out.println(s + " to " + v + ": ");
                Iterator it =  search.pathTo(v).iterator();
                while (it.hasNext())
                {

                    int x = (int) it.next();

                    if (x == s)
                    {
                        System.out.print(x);
                    }else
                    {
                        System.out.print("-" + x);
                    }
                }

                System.out.println();
            }
        }
    }
}
