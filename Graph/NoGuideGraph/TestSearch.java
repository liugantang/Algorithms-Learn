package Graph.NoGuideGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestSearch {
    public static void main(String[] args) throws FileNotFoundException {
        String fileAddress = "/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt";
        File file = new File(fileAddress);
        Scanner input = new Scanner(file);
        Scanner inputInteger = new Scanner(System.in);

        Graph g = new Graph(input);
        int s = inputInteger.nextInt();
        Search search = new Search(g, s);
        for (int v = 0; v< g.V(); v++)
        {
            if (search.marked(v))
            {
                System.out.println(v + " ");
            }
        }

        System.out.println();
        if (search.count() != g.V())
        {
            System.out.print("Not ");
        }

        System.out.println("Connect");
    }
}
