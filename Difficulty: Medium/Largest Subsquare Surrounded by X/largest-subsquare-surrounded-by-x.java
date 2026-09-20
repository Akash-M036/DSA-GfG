class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        if (n == 0) return 0;

        int[][] top = new int[n][n];
        int[][] left = new int[n][n];
        int[][] bottom = new int[n][n];
        int[][] right = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    bottom[i][j] = (i == n - 1) ? 1 : bottom[i + 1][j] + 1;
                    right[i][j] = (j == n - 1) ? 1 : right[i][j + 1] + 1;
                }
            }
        }

        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'O') {
                    continue;
                }

                int maxPossible = Math.min(bottom[i][j], right[i][j]);

                for (int k = maxPossible; k > maxSide; k--) {
                    int brI = i + k - 1;
                    int brJ = j + k - 1;

                    if (top[brI][brJ] >= k && left[brI][brJ] >= k) {
                        maxSide = Math.max(maxSide, k);
                        break;
                    }
                }
            }
        }

        return maxSide;
    }
}
