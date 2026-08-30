class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int[] pre = new int[l.length];
        pre[0] = r[0] - l[0] + 1;
        for (int i = 1; i < l.length; i++) {
            pre[i] = pre[i - 1] + (r[i] - l[i] + 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            int target = rank[i];
            int low = 0;
            int high = l.length - 1;
            int idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pre[mid] >= target) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (idx == -1) {
                result.add(-1);
            } else {
                int prevPre = (idx > 0) ? pre[idx - 1] : 0;
                int offset = target - prevPre;
                result.add(l[idx] + offset - 1);
            }
        }

        return result;
    }
}
