package Graph.NoGuideGraph;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.ST;
public class SymbolGraph {
    private edu.princeton.cs.algs4.ST<String, Integer> st;
    private String keys[];
    private Graph G;

    //根据filename指定的文件构造图，使用delim来分隔顶点名
    public SymbolGraph(String fileName, String delim) throws FileNotFoundException {
        st = new ST<>();
        File file = new File(fileName);
        Scanner stream = new Scanner(file);
        while (stream.hasNextLine())
        {
            String[] a = stream.nextLine().split(delim);

            for (int i = 0; i < a.length; i++)
            {
                if (!st.contains(a[i]))
                {
                    st.put(a[i], st.size());
                }
            }

        }

        keys = new String[st.size()];

        for (String name : st.keys())
        {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());

        stream = new Scanner(file);
        while (stream.hasNextLine())
        {
            String[] a = stream.nextLine().split(delim);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
            {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }
    //key是一个顶点吗？
    public boolean contain(String key)
    {
        return st.contains(key);
    }
    //key的索引
    int index(String key)
    {
        return st.get(key);
    }
    //索引v的顶点名
    String name(int v)
    {
        return keys[v];
    }
    //隐藏的Graph对象
    Graph G()
    {
        return G;
    }
}

