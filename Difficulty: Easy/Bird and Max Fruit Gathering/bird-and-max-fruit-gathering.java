import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        long[] pre = new long[2 * n];
        pre[0] = arr.get(0);

        for (int i = 1; i < 2 * n; i++) {
            pre[i] = pre[i - 1] + arr.get(i % n);
        }

        long total = pre[n - 1];
        long full = m / n;
        int rem = m % n;

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long cur = full * total;

            if (rem > 0) {
                int end = i + rem - 1;
                cur += pre[end] - (i > 0 ? pre[i - 1] : 0);
            }

            ans = Math.max(ans, cur);
        }

        return (int) ans;
    }
}