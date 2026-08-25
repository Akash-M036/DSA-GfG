class Solution {
    
    public int minMoves(int[] arr) {
        // code here
       if (arr.length <= 1) 
           return 0;
         int max =0;
         int[] dp = new int[arr.length+1];
         for(int i =0; i< arr.length;i++){
             dp[arr[i]] =dp[arr[i]-1]+1;
             max =Math.max(max, dp[arr[i]]);
         }
         return arr.length-max;
       
    }
}