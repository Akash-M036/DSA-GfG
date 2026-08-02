class Solution {
    public int cnt(int start , int n,int m,int arrcnt,int[][] dp){
        if(arrcnt==n){
            return 1;
        }
        if(start == m+1)
            return 0;
        if(dp[arrcnt][start]!=-1)
            return dp[arrcnt][start];
        int take =0;
        for(int i =1;i<=m;i++){
            if(start%i == 0 || i%start ==0)
              take += cnt(i,n,m,arrcnt+1,dp);
        }
        return dp[arrcnt][start] = take;
    }
    public int count(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
       return cnt(1,n,m,0,dp);
    }
}