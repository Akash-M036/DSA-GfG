class Solution {
    public int countWithout(int n, int d) {
         long ans =0;
        if(d==0){
        String s=n+"";
        int len=s.length();
        for(int i=1;i<len;i++) {
            ans+=9L*(long)Math.pow(9,i-1);
        }

        for(int i=0;i<len;i++) {
            int st=s.charAt(i)-'0';
            int rem=len-i-1;
            if(i==0) {
                for(int j=1;j<st;j++) {
                    if(j!=d)
                        ans+=(long)Math.pow(9,rem);
                }
            } 
            else {
                for(int j=0;j<st;j++) {
                    if(j!=d)
                        ans+=(long)Math.pow(9,rem);
                }
            }
            if(st==d)
                return (int)ans;
        }

        return (int)(ans+1);
        }
        
        else{

       int ncopy =n;
       int dig =0;
       int rev =0;
       while(ncopy!=0){
        rev =rev*10+ncopy%10;
            ncopy/=10;
            dig++;
       }
      
       while(rev!=0){
           int st = rev%10;
           if(st<d)
            ans += st*(Math.pow(9,dig-1));
            else if(st>d)
             ans += (st-1)*(Math.pow(9,dig-1));
            else{
               ans += st*(Math.pow(9,dig-1));
               ans--;
               break;
            }
           dig--;
           rev/=10;//5832   + 243 +
       }
        }
       return (int)ans;
    }
}