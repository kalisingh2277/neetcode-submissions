class Solution {
    public boolean exist(char[][] board, String word) {
        char word_arr[]=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word_arr[0] && check(word_arr,board,i,j,0))
                    return true;
            }
        }
        return false;
    }
    public static boolean check(char[] word_arr,char[][] board,int i, int j, int ind)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word_arr[ind] || board[i][j]=='*')
            return false;
        
        if(ind==word_arr.length-1)
            return true;
        
        char curr=board[i][j];
        board[i][j]='*';
        boolean res=check(word_arr,board,i+1,j,ind+1) || check(word_arr,board,i-1,j,ind+1) || check(word_arr,board,i,j+1,ind+1) || check(word_arr,board,i,j-1,ind+1);

        board[i][j]=curr;

        return res; 
    }
}