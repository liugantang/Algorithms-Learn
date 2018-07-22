package UnionFunction;

public class UF_Ultimate {
    private int id[];
    private int weight[];
    private int count;

    UF_Ultimate(int N)
    {
        id = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }

        for (int i = 0; i < N; i++)
        {
            weight[i] = i;
        }
    }

    public int getCount()
    {
        return count;
    }

    public int find(int p)
    {
        while (id[p] != p)
        {
            p = id[p];
        }

        return p;
    }

    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
        {
            return;
        }
        if (weight[pRoot] < weight[qRoot])
        {
            id[pRoot] = q;
            weight[qRoot] += weight[pRoot];

        }
        else
        {
            id[qRoot] = p;
            weight[pRoot] += weight[qRoot];
        }

        count--;
    }

}
