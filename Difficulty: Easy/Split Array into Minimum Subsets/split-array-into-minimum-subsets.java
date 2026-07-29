class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        int cnt = 1;
        for(int i =0; i< arr.length-1;i++){
            if(arr[i]+1 != arr[i+1])
            cnt++;
        }
        return cnt;
    }
}