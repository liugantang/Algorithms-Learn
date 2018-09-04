package Graph.DirectGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DGTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/NoGuideGraph/tinyG.txt");
        Scanner input = new Scanner(file);
        Digraph G = new Digraph(input);
        System.out.println(G.toString());
    }

}
