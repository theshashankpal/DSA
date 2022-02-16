class DisjointSet {
    int n;
    int parent[];
    int rank[];

    // My constructor is my makeSet
    public DisjointSet(int n){
        this.n = n;
        parent = new int[n];
        for(int i = 0; i < n ; i++)
            parent[i] = i;
        rank = new int[n];
        Arrays.fill(rank,0);
    }

    public boolean union(int x, int y)
    {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent)
            return false;
        else
        {
            if(rank[xParent] > rank[yParent])
                parent[yParent] = xParent;
            else if(rank[yParent] > rank[xParent])
                parent[xParent] = yParent;
            else
            {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
            return true;
        }
    }

    public int find(int x)
    {
        return findParent(x);
    }

    private int findParent(int x)
    {
        if(parent[x]==x)
            return x;
        int absoluteParent = findParent(parent[x]);
        parent[x] = absoluteParent;
        return absoluteParent;
    }
}
