class Solution {
    public int del(int i, int j,String s1, String s2,int c1, int c2,int[][] dp){
        if(i>s1.length() || j>s2.length())
            return Integer.MAX_VALUE;
        if(i==s1.length() && j==s2.length())
                return 0;
        if(i==s1.length() )
            return (s2.length()-j)*c2;
        if(j==s2.length())
            return (s1.length()-i)*c1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int match = Integer.MAX_VALUE;
        int rem1=Integer.MAX_VALUE;
        int rem2=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j))
            match = del(i+1,j+1,s1,s2,c1,c2,dp);
        else{
            int x ;
            x= del(i+1,j,s1,s2,c1,c2,dp);
            if(x!=Integer.MAX_VALUE)
            rem1 = c1+ x;
            int y =del(i,j+1,s1,s2,c1,c2,dp);
            if(y!=Integer.MAX_VALUE)
            rem2 = c2+y;
        }
        return dp[i][j]=Math.min(Math.min(rem1,rem2),match);
    }
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        
        return del(0,0,s1,s2,costS1,costS2,dp);
    }
}