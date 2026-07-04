class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int[] freq = new int[2 * n + 1];
        int offset = n;
        
        freq[0 + offset] = 1;
        int prefixSum = 0;
        int validSubstringsCount = 0;
        int currentValidCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                prefixSum++;
                currentValidCount += freq[prefixSum - 1 + offset];
            } else {
                prefixSum--;
                currentValidCount -= freq[prefixSum + offset];
            }
            
            validSubstringsCount += currentValidCount;
            freq[prefixSum + offset]++;
        }

        return validSubstringsCount;
    }
}
