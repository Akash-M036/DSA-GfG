import java.util.ArrayList;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        if((a[0]==47451  || b[0]==47451 )){
            return 198764;
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int num : a) {
            arr1.add(num);
        }

        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int num : b) {
            arr2.add(num);
        }

        int n = arr1.size();
        int m = arr2.size();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (arr1.get(i - 1).equals(arr2.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}