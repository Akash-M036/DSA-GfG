class Solution {
        
        public int ways(int n,int[] dp){
            if(n==0 || n==1)
                return 1;
            if(n<0)
                return 0;
            if(dp[n]!=-1)
                return dp[n];
            int take = (n-1)*ways(n-2,dp);
            int dont =  ways(n-1,dp);
            return dp[n]=take+dont;
        }
    public int countFriendsPairings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return ways(n,dp);
    }
}
/* 
ways(3)
ways(1)+ways(2);
0+ways(0)+ways(0)+ways(1);
1+1+1

ways(3)
3+ways(1)+ways(2);
3+1+
10*(3*1+1)+
*/
