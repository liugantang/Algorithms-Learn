package Graph.MinTrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CPM {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/home/liugantang/IdeaProjects/Algorithms/src/Graph/MinTrack/AnotherJobsPC.txt");
        Scanner input = new Scanner(data);
        int N = input.nextInt(); //顶点数量

        input.nextLine(); //读取顶点数量这一行
        EdgeWeightDigraph G = new EdgeWeightDigraph(2*N+2);
        int s = 2 * N;
        int t = 2 * N + 1;
        for (int i = 0; i < N; i++)
        {
            String[] a = input.nextLine().split("\\s+");
            double duration = Double.parseDouble(a[0]); //权重
            /*
            关于这里为什么要使用这种奇怪写法的说明
            line a其实是想表达i任务执行了duration个时间单位，但是放在图中不太好表达，就用i->i+N来表示
            line b是给所有顶点添加一条从s到该顶点的权重为0的边，这个原因是每个顶点都有可能是起始顶点，所以需要用这个技巧来方便后面来判定
            line c的意思在line a, b清楚之后也就很明白了，它就是添加一条从i指向终点t的边，这里使用i+N同样是一个小技巧
             */
            G.addEdge(new DirectedEdge(i, i+N, duration));//line a
            G.addEdge(new DirectedEdge(s, i, 0));//line b
            G.addEdge(new DirectedEdge(i+N, t, 0));//line c
            for (int j = 1; j < a.length; j++)
            {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i+N, successor, 0)); //根据优先级，添加一条从i指向successor的边
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);

        System.out.println("Start times:");
        for (int i = 0; i < N; i++)
        {
            System.out.format("%4d: %5.1f\n", i, lp.distTo(i));
        }
        System.out.format("Finish time: %5.1f\n", lp.distTo(t));
    }
}
