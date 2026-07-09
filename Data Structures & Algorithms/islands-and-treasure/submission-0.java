class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ans[][]=grid;
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int dis=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new Pair(i,j,dis));
                }
            }
        }
        int del_row[]={-1,0,1,0};
        int del_col[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int d=q.peek().dis;
            
            q.poll();
            for(int i=0;i<4;i++)
            {
                int nrow=row+del_row[i];
                int ncol=col+del_col[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==Integer.MAX_VALUE)
                {
                    ans[nrow][ncol]=1+d;
                    q.add(new Pair(nrow,ncol,d+1));
                }
            }
        }
        grid=ans;
        return;
    }
}
class Pair
{
    int row;
    int col;
    int dis;
    Pair(int row, int col, int dis)
    {
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
