class Solution {
    public int mod = 1000000007;
    public int sumw(int i , int j, int[][] grid, int[][] dp){
        if(i== grid.length-1 && j ==grid[0].length-1)
            return grid[i][j];
        if(i>=grid.length || i<0 ||j>=grid[0].length || j<0 )
            return Integer.MIN_VALUE;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int r =Integer.MIN_VALUE;
        int d=Integer.MIN_VALUE;
        if(grid[i][j]==1){
            int x = sumw(i,j+1,grid,dp);
            if(x!=Integer.MIN_VALUE)
           r = grid[i][j]+ x%mod;
        }
        else if(grid[i][j]==2){
            int x =sumw(i+1,j,grid,dp)%mod;
            if(x!= Integer.MIN_VALUE)
           d = grid[i][j] +x;
        }
        else{
          int x = sumw(i,j+1,grid,dp);
            if(x!=Integer.MIN_VALUE)
           r = grid[i][j]+ x%mod;
           int y =sumw(i+1,j,grid,dp)%mod;
            if(y!= Integer.MIN_VALUE)
           d = grid[i][j] +y;
           
        }
        return dp[i][j]=Math.max(r,d);
    }
    public int ways(int i ,int j, int[][] grid,int[][] dp){
        if(i== grid.length-1 && j ==grid[0].length-1)
            return 1;
        if(i>=grid.length || i<0 ||j>=grid[0].length || j<0 )
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j]%mod ;
        int r =0;
        int d=0;
        if(grid[i][j]==1)
           r =  ways(i,j+1,grid,dp);
        else if(grid[i][j]==2)
           d =  ways(i+1,j,grid,dp);
        else{
           r= ways(i+1,j,grid,dp);
           d =ways(i,j+1,grid,dp);
        }
        return dp[i][j]=(r%mod+d%mod)%mod;
    }
    public ArrayList<Integer> findWays(int[][] grid) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] dp = new int[grid.length][grid.length];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        int x = ways(0,0,grid,dp);
        ans.add(x);
        if(x==0){
            ans.add(0);
            return ans;
        }
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        
        ans.add(sumw(0,0,grid,dp));
        return ans;
    }
}