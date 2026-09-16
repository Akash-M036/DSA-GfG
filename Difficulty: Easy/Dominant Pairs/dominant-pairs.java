class Solution {
    public int dominantPairs(int[] arr) {
        // Code here
        int[] firsthalf =  new int[arr.length/2];
        int[] sechalf =  new int[arr.length/2];
        for(int i =0; i< arr.length;i++){
            if(i<arr.length/2)
                firsthalf[i]=arr[i];
            else
                sechalf[i-arr.length/2]=arr[i];
        }
        Arrays.sort(sechalf);
        Arrays.sort(firsthalf);
        int ans =0;
        for(int i =0 ; i< arr.length/2;i++){
            int j =0;
            while(j<arr.length/2 && firsthalf[i]>=5*sechalf[j])
                j++;
            ans+=j;
        }
        return ans;
    }
}