import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minDeletions(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == lis.size()) {
                lis.add(num);
            } else { 
                lis.set(idx, num);
            }
        }
        
        return arr.length - lis.size();
    }
}
