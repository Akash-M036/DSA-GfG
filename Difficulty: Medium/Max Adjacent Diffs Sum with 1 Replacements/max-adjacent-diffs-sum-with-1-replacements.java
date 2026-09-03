class Solution {
    long[][] dp;

    public long maxDiffSum(int[] arr) {
        int n = arr.length;
        dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
long keep = solve(arr, 1, 0);
long replace = solve(arr, 1, 1);

// Add the contribution of the first pair through recursion
// is handled by solve() based on the previous choice.
return Math.max(keep, replace);
    }

    long solve(int[] arr, int i, int prev) {
        if (i == arr.length)
            return 0;
        if (dp[i][prev] != -1)
            return dp[i][prev];
        int previous = (prev == 0) ? arr[i - 1] : 1;
        // Keep current element
        long keep = Math.abs(previous - arr[i]) + solve(arr, i + 1, 0);
        // Replace current element with 1
        long replace = Math.abs(previous - 1)+ solve(arr, i + 1, 1);

        return dp[i][prev] = Math.max(keep, replace);
    }
}