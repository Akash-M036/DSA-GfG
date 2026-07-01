class Solution:
    def nCr(self, n, r):
        # code here
        pref=[0]*101
        pref[0]=1 
        pref[1]=1 
        for i in range(2,101):
            pref[i]=pref[i-1]*i 
        return pref[n]//(pref[n-r]*pref[r])