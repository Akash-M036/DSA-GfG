class Solution {
    public int maxSumSubarray(int[] arr) {
        
        int curr=0;
        int maxval=Integer.MIN_VALUE;
        int n =arr.length;
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            if(arr[i]>curr+arr[i]){
                curr=arr[i];
                
            }
            else{
                curr+=arr[i];
            }
            if(maxval<curr){
                maxval=curr;
            }
            dp1[i]=curr;
        }
        curr=0;
         for(int i =arr.length-1;i>=0;i--){
            if(arr[i]>curr+arr[i]){
                curr=arr[i];
            }
            else{
                curr+=arr[i];
            }
            if(maxval<curr){
                maxval=curr;
            }
            dp2[i]=curr;
        }
      
        for (int i = 1; i < n - 1; i++) {
            int missi = dp1[i - 1] + dp2[i + 1];
            if (missi > maxval) {
                maxval = missi;
            }
        }
        return maxval;
    }
}