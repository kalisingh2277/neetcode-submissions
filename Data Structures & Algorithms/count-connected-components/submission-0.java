class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int edge[]:edges)
            {
                int u=edge[0];
                int v=edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        int vis[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]!=1)
            {
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
    public static void dfs(int node,int vis[], ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int neigh:adj.get(node))
        {
            if(vis[neigh]!=1)
            {
                dfs(neigh,vis,adj);
            }
        }
        return;
    }
}
