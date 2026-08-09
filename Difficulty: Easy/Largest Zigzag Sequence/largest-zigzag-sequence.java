class Solution {
    public int path(int i , int j,int[][] mat,int[][] dp){
        if(mat.length==1)
            return mat[0][0];
        if(i>=mat.length||j>=mat.length ||j<0 ||i<0)
            return 0;
        if (i == mat.length - 1) return mat[i][j]; 
        if(dp[i][j]!=-1)
            return dp[i][j];
        int take = mat[i][j];
        int m = -1;
        for(int k =0; k<mat.length;k++){
            if(j!=k){
                m=Math.max(path(i+1,k,mat,dp),m);
            }
        }
        take+=m;
        return dp[i][j]= take;
    }
    public int zigzagSequence(int[][] mat) {
        int[][] dp = new int[mat.length][mat.length];
        for(int[] rows : dp)
            Arrays.fill(rows,-1);
        int maxans =-1;
        for(int i =0; i<mat.length;i++){
         maxans = Math.max(maxans,path(0,i,mat,dp));
        }
        return maxans;
    }
}