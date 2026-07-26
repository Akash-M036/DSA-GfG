class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < (int) Math.pow(2, prev)) {
                pq.offer(arr[i]);
            } else {
                ArrayList<Integer> a = new ArrayList<>();
                while (!pq.isEmpty()) {
                    a.add(pq.poll());
                }
                ans.add(a);
                prev++;
                pq.offer(arr[i]);
            }
        }
        if (!pq.isEmpty()) {
            ArrayList<Integer> a = new ArrayList<>();
            while (!pq.isEmpty()) {
                a.add(pq.poll());
            }
            ans.add(a);
        }
        return ans;
    }
}