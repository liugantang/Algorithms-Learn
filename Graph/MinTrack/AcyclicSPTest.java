package Graph.MinTrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AcyclicSPTest {
    public static void main(String[] args) throws FileNotFoundException {
        EdgeWeightDigraph G;
        File data = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTrack/mineEWG.txt");
        Scanner input = new Scanner(data);
        G = new EdgeWeightDigraph(input);

        Scanner inputNum = new Scanner(System.in);
        int s = inputNum.nextInt();
        AcyclicSP sp = new AcyclicSP(G, s);

        for (int t = 0; t < G.V(); t++) {
            System.out.println(s + " to " + t);
            System.out.format(" (%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    System.out.print(e + "  ");
                }
            }
            System.out.println();
        }
    }
}
