class Solution {
    public int minProd(int[] arr) {
         int mini = Integer.MAX_VALUE;
         int cntneg =0;
         for(int a : arr){
             mini = Math.min(a,mini);
             if(a<0)
                cntneg++;
         }
         if(mini >= 0  || cntneg==0)
            return mini;
        Arrays.sort(arr);
        int ans =1;
        if(cntneg%2!=0){
            for(int a : arr){
                if(a==0) continue;
                ans = ans * a;
            }
        }
        else{
        for(int i =0; i< arr.length;i++){
            if(arr[i]==0) continue;
            if(i+1<arr.length && arr[i]<0 && arr[i+1]>=0) continue;
            if(arr[i]<0 && i==arr.length-1) continue;
            ans = ans *arr[i];
        }
        
        }
        return ans;
    }
}