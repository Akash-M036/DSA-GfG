class Solution {
     int mod = (int)1e9+7;
     public int anscnt(int z, int o,int strcnt,int[][] dp){
         if(z>o)
            return 0;
         if(z+o==strcnt && (z==strcnt/2 && o==strcnt/2)){
             return 1;
         }
         if(z+o>strcnt){
             return 0;
         }
         if(dp[z][o] != -1)
            return dp[z][o];
         int ans1 =anscnt(z+1,o,strcnt,dp)%mod;
         int ans2 =anscnt(z,o+1,strcnt,dp)%mod;
         return dp[z][o] = (ans1+ans2)%mod;
     }
    public int prefixStrings(int n) {
        // code here
       // int strcnt = 2*n;
        int[][] dp = new int[2*n+1][2*n+1];
        // for(int[] rows : dp){
        //     Arrays.fill(rows,-1);
        // }
        //return anscnt(0,0,strcnt,dp);
        dp[0][0]=1;
        for(int i =0; i<=n; i++){
            for(int j =0; j<=i;j++){
                if(i==0 &&j==0) continue;
                int answays =0;
                if(i>0)
                    answays+= dp[i-1][j]%mod;
                if(j>0 && i>=j)
                    answays += dp[i][j-1]%mod;
                dp[i][j]=(int)(answays%mod);
            }
        }
        return dp[n][n];
        
    }
}