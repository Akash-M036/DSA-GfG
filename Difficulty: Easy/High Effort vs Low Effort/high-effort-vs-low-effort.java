class Solution {
    public int taskdone(int i,int[] h , int[] l,int[][] dp,int task){
        if(i==h.length){
            return 0;
        }
        if(dp[i][task]!=-1)
            return dp[i][task];
            int high =0;
        int nowork = taskdone(i+1,h,l,dp,0);
        if((i>=1 && task == 0)|| i==0)
         high = h[i]+taskdone(i+1,h,l,dp,1);
        int low = l[i]+taskdone(i+1,h,l,dp,1);
         
        // 
         return dp[i][task]=Math.max(nowork,Math.max(high,low));
    }
    public int maxTask(int[] h, int[] l) {
        int[][] dp = new int[h.length][2];
        for(int[] rows : dp)
        Arrays.fill(rows,-1);
        return taskdone(0,h,l,dp,0);
    }
}