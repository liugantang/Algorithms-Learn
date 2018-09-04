package Graph.MinTree;

public class Edge implements Comparable<Edge>{

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    //边的权重
    public double weight()
    {
        return weight;
    }
    //边的两个顶点之一
    public int either()
    {
        return v;
    }
    //边的另外一个顶点
    public int other(int vertex)
    {
        if (vertex == v)
        {
            return w;
        }
        else if (vertex == w)
        {
            return v;
        }
        else
        {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    //权重比较
    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight)
        {
            return -1;
        }
        else if (this.weight > that.weight)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d - %d (%.2f)", v, w, weight);
    }
}
