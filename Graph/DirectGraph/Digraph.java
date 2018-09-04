package Graph.DirectGraph;

import Graph.NoGuideGraph.Bag;

import java.util.Scanner;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    //创建一个含有v个顶点但没有边的有向图
    public Digraph(int v)
    {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V];
        for (int i = 0; i < v; i++)
        {
            adj[i] = new Bag<Integer>();
        }

    }
    //从输入流input中读取一个有向图
    public Digraph(Scanner input)
    {
        this(input.nextInt());
        int edge = input.nextInt();

        for (int i = 0; i < edge; i++)
        {
            int v = input.nextInt();
            int w = input.nextInt();
            addEdge(v, w);
        }
    }
    //返回顶点数
    public int V()
    {
        return V;

    }
    //返回边的总数
    public int E()
    {
        return E;
    }
    //添加一条从v指向w的边
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        E++;
    }
    //由v指出的边所连接的所有节点
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    //图的反向图
    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
        {
            for (int w : adj(v))
            {
                R.addEdge(w, v);
            }
        }

        return R;
    }
    //对象的字符串表示
    public String toString()
    {
        String s = "Vertices: " + V + " Edges: " + E + "\n";
        s += "Follow is connect of vertices\n";

        for (int v = 0; v < V; v++)
        {
            s = s + v + " to ";
            for (int w : adj(v))
            {
                s = s + w + " ";
            }
            s = s + "\n";
        }

        return s;
    }
}
