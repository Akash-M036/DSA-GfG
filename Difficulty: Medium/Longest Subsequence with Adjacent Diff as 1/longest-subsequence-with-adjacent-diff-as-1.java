class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        int ans =-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i< arr.length;i++){
            int curr =1;
            if(map.containsKey(arr[i]+1)){
                curr = Math.max(map.get(arr[i]+1)+1,curr);
            }
             if(map.containsKey(arr[i]-1)){
                curr = Math.max(map.get(arr[i]-1)+1,curr);
            }
            map.put(arr[i],Math.max(map.getOrDefault(arr[i], 0), curr));
            ans = Math.max(ans, map.get(arr[i]));
        }
        return ans;
        }
}
