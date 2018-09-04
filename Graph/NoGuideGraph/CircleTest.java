package Graph.NoGuideGraph;

public class CircleTest {
    public static void main(String[] args)
    {
        Graph G = new Graph(4);
        G.addEdge(1, 2);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);

        Circle circle = new Circle(G);
        System.out.println(circle.hasCircle());
    }
}
