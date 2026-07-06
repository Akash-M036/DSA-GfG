class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<arr.length;i++){
            if(arr[i]>=low && arr[i]<=high)
                set.add(arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(low<=high){
            if(!set.contains(low)){
                ans.add(low);
            }
            low++;
        }
        return ans;
        
    }
}