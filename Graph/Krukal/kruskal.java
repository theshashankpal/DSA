class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        
        TreeSet<Edge> tree = new TreeSet<>();
        
        for(int i = 0 ; i < V ; i++)
        {
            ArrayList<ArrayList<Integer>> outerList = adj.get(i);
            for(ArrayList<Integer> innerList : outerList)
            {
                tree.add(new Edge(i,innerList.get(0),innerList.get(1)));
            }
        }
        
        Iterator<Edge> iterator = tree.iterator();
        
        DisjointSet disj = new DisjointSet(V);
        
        int sum = 0;
        
        while(iterator.hasNext())
        {
            Edge temp = iterator.next();
            int i = temp.i;
            int j = temp.j;
            if(disj.union(i,j)==true)
                sum+=temp.weight;
        }
        return sum;
    }
}


class Edge implements Comparable<Edge>{
    int i;
    int j;
    int weight;
    
    public Edge(int i, int j , int weight){
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
    
   @Override
    public int compareTo(Edge e1)
    {
        int compare = Integer.compare(this.weight,e1.weight);
        if(compare == 0)    
        {
            int tempI = Integer.compare(this.i,e1.i);
            int tempJ = Integer.compare(this.j,e1.j);
            if(tempI==0 && tempJ ==0) 
                return 0;
            else
                {
                    if(tempI != 0)
                        compare = tempI;
                    else
                        compare = tempJ;
                }
        }
        return compare;
    }
}
