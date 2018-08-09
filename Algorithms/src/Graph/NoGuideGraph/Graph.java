package Graph.NoGuideGraph;

import java.util.Scanner;

public class Graph {

    private int V;
    private int E;
    private Bag<Integer> adj[];

    //创建一个含有v个顶点的图
    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++)
        {
            adj[i] = new Bag<>();
        }
    }
    //从输入中读入一张图
    public Graph (Scanner input)
    {
        this(input.nextInt());
         this.E = input.nextInt();
        for (int i = 0; i < E; i++)
        {
            int v = input.nextInt();
            int w = input.nextInt();
            addEdge(v, w);
        }
    }
    //边数
    public int E()
    {
        return E;
    }
    //顶点数
    public int V()
    {
        return V;
    }
    //向图中添加一条边v-w
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    //和v相邻的所有顶点
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    //对象的字符串表示
    public String toString()
    {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++)
        {
            s += v + ": ";
            for (int w : this.adj(v))
            {
                s += w + " ";

            }
            s += "\n";
        }

        return s;
    }


}
