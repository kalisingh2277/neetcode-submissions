class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        DisjointSet ds=new DisjointSet(n);
        // 1. A valid tree MUST have exactly n - 1 edges. 
        // If it doesn't, it's either disconnected or has a cycle.
        if (edges.length != n - 1) {
            return false;
        }
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

            for(int edge[]:edges)
            {
                int u=edge[0];
                int v=edge[1];
                if(ds.ultimateParent(u)==ds.ultimateParent(v))
                    return false;
                else
                {
                    ds.union(u,v);
                }
            }
        
        return true;

    }
}
class DisjointSet
{
    int rank[];
    int parent[];
    DisjointSet(int n)
    {
        rank=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++)
        {
            rank[i]=0;
            parent[i]=i;
        }
    }
    public int ultimateParent(int node)
    {
        if(parent[node]==node)
        {
            return node;
        }
        return parent[node]=ultimateParent(parent[node]);
    }
    public void union(int u, int v)
    {
        int upu=ultimateParent(u);
        int upv=ultimateParent(v);

        if(upu==upv)
            return;
        
        if(rank[upu]<rank[upv])
        {
            parent[upu]=upv;
        }
        else if(rank[upv]<rank[upu])
        {
            parent[upv]=upu;
        }
        else
        {
            parent[upv]=upu;
            rank[upu]++;
        }
        return;
    }
}
