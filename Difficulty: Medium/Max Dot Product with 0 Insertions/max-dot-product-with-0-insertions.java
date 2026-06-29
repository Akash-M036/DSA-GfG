class Solution {
    int[][] dp;

    int solve(int i, int j, int[] a, int[] b) {
        if (j == b.length)
            return 0;

        if (i == a.length)
            return Integer.MIN_VALUE / 2;

        if (dp[i][j] != -1)
            return dp[i][j];

        int skip = solve(i + 1, j, a, b);

        int take = a[i] * b[j] + solve(i + 1, j + 1, a, b);

        return dp[i][j] = Math.max(skip, take);
    }

    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length ;
        int m = b.length;
        dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, a, b);
    }
}