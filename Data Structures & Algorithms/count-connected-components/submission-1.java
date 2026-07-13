class Solution {
    public int countComponents(int n, int[][] edges) {
    //     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    //     for(int i=0;i<n;i++)
    //     {
    //         adj.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int edge[]:edges)
    //         {
    //             int u=edge[0];
    //             int v=edge[1];
    //             adj.get(u).add(v);
    //             adj.get(v).add(u);
    //         }
    //     }

    //     int vis[]=new int[n];
    //     int count=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         if(vis[i]!=1)
    //         {
    //             count++;
    //             dfs(i,vis,adj);
    //         }
    //     }
    //     return count;
    // }
    // public static void dfs(int node,int vis[], ArrayList<ArrayList<Integer>> adj)
    // {
    //     vis[node]=1;
    //     for(int neigh:adj.get(node))
    //     {
    //         if(vis[neigh]!=1)
    //         {
    //             dfs(neigh,vis,adj);
    //         }
    //     }
    //     return;


    DisjointSet ds=new DisjointSet(n);

        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }

        int count=0;
        for(int i=0;i<n;i++)
        {
            //if you are your own ultimate parent then inc count (technically count no. of bosses)
            if(ds.findUltimateParent(i)==i)
                count++;
        }
        return count;
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
        //0 based indexing
        for(int i=0;i<n;i++)
        {
            rank[i]=0;
            parent[i]=i;
        }

    }

    public int findUltimateParent(int node)
    {
        if(node==parent[node])
            return node;
        return parent[node]=findUltimateParent(parent[node]);
    }

    public void union(int u, int v)
    {
        int upu=findUltimateParent(u);
        int upv=findUltimateParent(v);

        if(upu==upv)
            return;//already in same province/component

        //attach smaller tree under larger tree
        if(rank[upu]<rank[upv])
        {
            parent[upu]=upv;
        }
        else if(rank[upv]<rank[upu])
        {
            parent[upv]=upu;
        }
        else// Ranks are equal, attach one to the other and increase rank
        {
            parent[upv]=upu;
            rank[upu]++;
        }
    }
}
