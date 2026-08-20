class Solution {
    public int findSuffixMatch(int i, int j, char[] arr1, char[] arr2) {
        if (i < 0 || j < 0) {
            return j + 1;
        }
        if (arr1[i] == arr2[j]) {
            return findSuffixMatch(i - 1, j - 1, arr1, arr2);
        }
        return findSuffixMatch(i - 1, j, arr1, arr2);
    }

    int transform(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[] counts = new int[256];
        for (int i = 0; i < n; i++) {
            counts[arr1[i]]++;
            counts[arr2[i]]--;
        }

        for (int i = 0; i < 256; i++) {
            if (counts[i] != 0) {
                return -1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) {
                cnt++;
            } else {
                break;
            }
        }
        if (cnt == n) return 0;

        return findSuffixMatch(n - 1, n - 1, arr1, arr2);
    }
}
