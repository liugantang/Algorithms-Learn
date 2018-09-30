package Graph.MinTrack;

//求给定两点的最短距离， Dijkstra实现
public class DijkstraAllPairsSP {
    private SP[] all;

    DijkstraAllPairsSP(EdgeWeightDigraph G) {
        all = new SP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new SP(G, v);
        }

    }

    Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    double dist(int s, int t) {
        return all[s].distTo(t);
    }
}