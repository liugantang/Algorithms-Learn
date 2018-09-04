package Graph.DirectGraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
    private boolean marked[];
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G)
    {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v])
            {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v)
    {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (!marked[w])
            {
                dfs(G, w);
            }
        }

        post.enqueue(v);
        reversePost.push(v);
    }
    //前序遍历
    public Iterable<Integer> pre()
    {
        return pre;
    }
    //后序遍历
    public Iterable<Integer> post()
    {
        return post;
    }
    //逆后序遍历
    public Iterable<Integer> reversPost()
    {
        return reversePost;
    }
}
