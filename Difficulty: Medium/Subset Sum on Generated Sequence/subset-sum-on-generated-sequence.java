class Solution {
    boolean found = false;
    public long find(int i, long[] stu, int x,long[] dp){
        if(found)
            return 0;
        if(i>stu.length-1)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        long take = stu[i]+find(i+1,stu,x,dp);
        long dont = find(i+1,stu,x,dp);
        if(!found){
            if(take==x || dont ==x)
                found=true;
        }
        if(take>x)
            return dp[i]= dont;
        return dp[i]=take;
        
    }
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        long[] stu = new long[arr.length+1];
        long[] dp = new long[stu.length];
        stu[0]=s;
        long sum=s;
        for(int i =1; i<stu.length;i++){
            stu[i]= sum+arr[i-1]; 
            sum += stu[i];
        }
        Arrays.fill(dp,-1);
        find(0,stu,x,dp);
        return found;
    }
}