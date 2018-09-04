package Graph.NoGuideGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CCTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt");
        Scanner input = new Scanner(file);
        Graph g = new Graph(input);
        CC cc = new CC(g);
        int M = cc.count();
        System.out.println(M + " Components");

        Bag<Integer>[] Components = (Bag<Integer>[])new Bag[M];
        for (int i = 0; i < M; i++)
        {
            Components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < g.V(); v++)
        {
            Components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++)
        {
            for (int v : Components[i])
            {
                System.out.print(v + " ");
            }

            System.out.println();
        }
    }
}
