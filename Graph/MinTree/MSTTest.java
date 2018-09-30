package Graph.MinTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSTTest {
    public static void main(String[] args) throws FileNotFoundException {
        File doc = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTree/tinyEWG.txt");
        Scanner input = new Scanner(doc);
        EdgeWeightGraph G = new EdgeWeightGraph(input);
        //PrimMST lazyPrimMst = new PrimMST(G);
        KruskalMST lazyPrimMst = new KruskalMST(G);
        //LazyPrimMST lazyPrimMst = new LazyPrimMST(G);
        for (Edge e : lazyPrimMst.edges())
        {
            System.out.println(e);
        }
        System.out.println(lazyPrimMst.weight());
    }
}
