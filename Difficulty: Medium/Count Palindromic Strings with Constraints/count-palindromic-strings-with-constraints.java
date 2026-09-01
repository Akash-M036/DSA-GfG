class Solution {
    public int palindromicStrings(int n, int k) {
        // code here
        /*
        n=3 , k=2
        k + k*1 + k*k-1*1 + k*(k-1)*1*1+ k*(k-1)*(k-2)*1*1 -- 18+6=24
        k+ k*1+ k*k-1*1=0
        */
        int mod = (int)1e9+7;
        int i = 1;
        int ans =0;
        int charc=k;
        int j =1;
        while(i<=n){
            j=1;
            while(i<=n && j<=2){
                 charc=k;
                int x =(i+1)/2;
                long val = 1;
                while(x>0){
                    if(charc<0) break;
                    val = (val%mod*charc)%mod;
                    charc--;
                    x--;
                }
                if(!(charc<0)) 
                    ans = (ans%mod+ (int)val)%mod;
                i++;
                j++;
            }
        }
        return ans%mod;
    }
}