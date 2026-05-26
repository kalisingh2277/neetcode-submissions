class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int s=0;
        int e=m-1;
        int mid=s+(e-s)/2;
        while(s<=e)
        {
            if(matrix[mid][0]==target)
                return true;
            else if(matrix[mid][0]<target)
                s=mid+1;
            else
                e=mid-1;
            mid=s+(e-s)/2;
        }
        if(e<0)
            return false;

        return searchrow(matrix,e,n,target);
    }
    public static boolean searchrow(int[][] matrix, int s, int n,int target)
    {
        int start=0;
        int end=n-1;
        int mid=start+(end-start)/2;
        while(start<=end)
        {
            if(matrix[s][mid]==target)
                return true;
            else if(matrix[s][mid]<target)
                start=mid+1;
            else
                end=mid-1;
            mid=start+(end-start)/2;

        }
        return false;
    }
}
