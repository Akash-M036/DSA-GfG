import java.util.Arrays;

class Solution {
    public int maxIndexDifference(String s) {
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currentClass = ch - 'a';
            if (ch == 'a') {
                if (lastIdx[0] == -1) {
                    lastIdx[0] = i;
                }
            } else {
                int prevClass = currentClass - 1;
                if (lastIdx[prevClass] != -1) {
                    lastIdx[currentClass] = i;
                    ans = Math.max(ans, i - lastIdx[0]);
                }
            }
        }
        return lastIdx[0] == -1 ? -1 : ans;
    }
}
