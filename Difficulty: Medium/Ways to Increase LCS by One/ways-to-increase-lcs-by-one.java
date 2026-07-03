import java.util.HashSet;
import java.util.Set;

class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // 1. Prefix DP Matrix
        int[][] dp1 = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
                } else {
                    dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]);
                }
            }
        }
        
        int originalLCS = dp1[m][n];
        
        // 2. Suffix DP Matrix
        int[][] dp2 = new int[m + 2][n + 2];
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp2[i][j] = dp2[i + 1][j + 1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i][j + 1]);
                }
            }
        }
        
        // Tracks unique positional choices: "index_char"
        Set<String> validWays = new HashSet<>();
        
        // 3. Evaluate each character at every insertion position i (0 to m)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = s2.charAt(j);
                
                // Formulate LCS if 'ch' from s2[j] is inserted at s1[i]
                int currentLCS = dp1[i][j] + 1 + dp2[i + 1][j + 2];
                
                if (currentLCS == originalLCS + 1) {
                    // Uniquely key the way by its (Position in S1 + Character)
                    validWays.add(i + "_" + ch);
                }
            }
        }
        
        return validWays.size();
    }
}
