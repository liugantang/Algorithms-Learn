package Graph.DirectGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class DfsPathTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt");
        Scanner input = new Scanner(file);
        Scanner inputI = new Scanner(System.in);
        int s = inputI.nextInt();
        Digraph g = new Digraph(input);
        DfsPath search = new DfsPath(g, s);

        for (int v = 0; v < g.V(); v++)
        {

            if (search.hasPathTo(v))
            {
                System.out.println(s + " to " + v + ": ");
                Iterator it =  search.route(v).iterator();
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
