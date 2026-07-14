class Solution {
    public int find(int[] arr) {
        int maxval= -1;
        int leastval=Integer.MAX_VALUE;
        for(int i =0; i< arr.length;i++){
            maxval= Math.max(arr[i],maxval);
            leastval= Math.min(arr[i],leastval);
        }
        leastval=0;
        while(leastval<=maxval){
            int mid = (leastval+maxval)/2;
            double x=mid;
            for(int i=0; i< arr.length;i++){
                if(arr[i]<x)
                    x+=(x-arr[i]);
                else
                    x-=(arr[i]-x);
            }
            if(x>=0)
                maxval= mid-1;
            else if(x<0)
                leastval=mid+1;
        }
        return leastval;
        
    }
}
