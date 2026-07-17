class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        int[] lMx = new int[n];
        int[] lMn = new int[n];
        int[] rMx = new int[n];
        int[] rMn = new int[n];

        int mx = arr[0], mn = arr[0];
        int cMx = arr[0], cMn = arr[0];
        lMx[0] = arr[0];
        lMn[0] = arr[0];

        for (int i = 1; i < n; i++) {
            cMx = Math.max(arr[i], cMx + arr[i]);
            mx = Math.max(mx, cMx);
            lMx[i] = mx;

            cMn = Math.min(arr[i], cMn + arr[i]);
            mn = Math.min(mn, cMn);
            lMn[i] = mn;
        }

        mx = arr[n - 1];
        mn = arr[n - 1];
        cMx = arr[n - 1];
        cMn = arr[n - 1];
        rMx[n - 1] = arr[n - 1];
        rMn[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            cMx = Math.max(arr[i], cMx + arr[i]);
            mx = Math.max(mx, cMx);
            rMx[i] = mx;

            cMn = Math.min(arr[i], cMn + arr[i]);
            mn = Math.min(mn, cMn);
            rMn[i] = mn;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int d1 = Math.abs(lMx[i] - rMn[i + 1]);
            int d2 = Math.abs(lMn[i] - rMx[i + 1]);
            ans = Math.max(ans, Math.max(d1, d2));
        }

        return ans;
    }
}
