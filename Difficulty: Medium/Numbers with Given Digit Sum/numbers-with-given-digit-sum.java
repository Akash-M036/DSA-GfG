class Solution {
    public int ways(int dig, int sum,boolean start,int[][] dp){
        if(dig==0){
            if(sum==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(sum<0)
            return 0;
        if(dp[dig][sum]!=-2)
            return dp[dig][sum];
        int ans=0;
        int val =0;
        for(int i = 0;i<=9;i++){
            if(start && i==0)
                continue;
            ans = ways(dig-1,sum-i,false,dp);
            val+=ans;
        }
        return dp[dig][sum]= val;
    }
    public int countWays(int n, int sum) {
       int[][] dp = new int[n+1][sum+1];
        for(int[] r : dp){
            Arrays.fill(r,-2);
        }
       return ways(n,sum,true,dp)==0?  -1 : ways(n,sum,true,dp);
        
    }
};