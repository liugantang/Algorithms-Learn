package Graph.DirectGraph;

public class SccTest {
    public static void main(String[] args)
    {
        Digraph G = new Digraph(10);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 6);
        G.addEdge(6, 5);
        G.addEdge(5, 4);
        G.addEdge(1, 4);
        G.addEdge(5, 8);
        G.addEdge(8, 7);
        G.addEdge(7, 8);
        G.addEdge(8, 9);
        G.addEdge(9, 8);

        SCC scc = new SCC(G);
        System.out.println(scc.count());
        System.out.println(scc.id(0));
        System.out.println(scc.id(3));
        System.out.println(scc.id(8));
    }
}
