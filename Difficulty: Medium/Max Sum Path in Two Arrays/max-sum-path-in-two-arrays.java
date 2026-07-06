class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int right = 0;
        int ans = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < a.length; i++) {
            sum1 += a[i];
            sum2 = 0; 
            
            for (int j = right; j < b.length; j++) {
                sum2 += b[j];
                
                if (a[i] == b[j]) {
                    if (sum1 > sum2) {
                        ans += sum1;
                    } else {
                        ans += sum2;
                    }
                    sum1 = 0;
                    sum2 = 0;
                    right = j + 1;
                    break; 
                }
            }
        }

        sum2 = 0;
        for (int j = right; j < b.length; j++) {
            sum2 += b[j];
        }

        if (sum1 > sum2) {
            ans += sum1;
        } else {
            ans += sum2;
        }

        return ans;
    }
}
