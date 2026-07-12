class Solution {
    public boolean validTree(int n, int[][] edges) {
        //checks for cycles and correct no. of edges needed
        if(edges.length!=n-1)
            return false;

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
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        int vis[]=new int[n];

        q.add(0);
        vis[0]=1;

        while(!q.isEmpty())
        {
            int node=q.peek();
            q.poll();
            res.add(node);
            for(int neigh:adj.get(node))
            {
                if(vis[neigh]==0)
                {
                    vis[neigh]=1;
                    q.add(neigh);
                }
            }
        }
        if(res.size()==n)
            return true;
        return false;
    }
}
