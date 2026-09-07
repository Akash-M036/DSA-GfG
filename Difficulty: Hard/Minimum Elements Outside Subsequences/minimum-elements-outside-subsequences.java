import java.util.Arrays;

class Solution {
    public int values(int idx, int prevmaxIdx, int prevminIdx, int[] arr, int[][][] dp){
        if(idx >= arr.length) return 0;

        if(dp[idx][prevmaxIdx + 1][prevminIdx + 1] != -1)
            return dp[idx][prevmaxIdx + 1][prevminIdx + 1];

        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;

        int ans3 = values(idx + 1, prevmaxIdx, prevminIdx, arr, dp);

        if(prevmaxIdx == -1 || arr[prevmaxIdx] < arr[idx]) {
            ans1 = 1 + values(idx + 1, idx, prevminIdx, arr, dp);
        }

        if(prevminIdx == -1 || arr[prevminIdx] > arr[idx]) {
            ans2 = 1 + values(idx + 1, prevmaxIdx, idx, arr, dp);
        }

        return dp[idx][prevmaxIdx + 1][prevminIdx + 1] = Math.max(Math.max(ans1, ans2), ans3);  
    }

    public int minCount(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][n + 1][n + 1];
        for(int[][] x: dp){
            for(int[] y:x){
                Arrays.fill(y, -1);
            }
        }
        return arr.length - values(0, -1, -1, arr, dp);
    }
}
