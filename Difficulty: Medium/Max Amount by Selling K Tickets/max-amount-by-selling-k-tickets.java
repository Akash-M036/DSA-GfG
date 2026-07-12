import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int maxAmount(int[] arr, int k) {
        // 1. Use a Max-Heap to always get the largest element easily
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : arr) {
            if (num > 0) {
                maxHeap.add(num);
            }
        }
        
        long cost = 0; // Use long to prevent integer overflow during addition
        int mod = 1000000007;
        
        // 2. Process until we run out of moves (k) or elements
        while (k > 0 && !maxHeap.isEmpty()) {
            int maxVal = maxHeap.poll(); // Get the largest element
            
            cost = (cost + maxVal) % mod;
            
            // If the decremented value is still greater than 0, put it back
            if (maxVal - 1 > 0) {
                maxHeap.add(maxVal - 1);
            }
            
            k--;
        }
        
        return (int) cost;
    }
}
