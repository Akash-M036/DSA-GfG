class Solution {
    public int findMax(int n) {
        if(n<10)
            return n;
        int ncopy = n;
        int ans = 0;
        String rev = new StringBuilder(String.valueOf(ncopy)).reverse().toString();
        while(!rev.isEmpty()){
            int dig1 = rev.charAt(rev.length() - 1) - '0';
            rev = rev.substring(0, rev.length() - 1);
            if(rev.isEmpty()){
                  ans = ans * 10 + dig1;
                break;
            }
            int dig2 = rev.charAt(rev.length() - 1) - '0';
            int x = (dig1-1)*10+9;
            int y = dig1*10+dig2;
            if(dig2!=9)
            {
                if(rev.length() <= 1) {
                    if(y%10 == 8){
                        ans = ans*100+y;
                        return ans;
                    }
                }
                ans = ans*100+x;
                rev = rev.substring(0, rev.length() - 1);
                while(!rev.isEmpty()){
                    ans = ans*10+9;
                    rev = rev.substring(0, rev.length() - 1);
                }
                break;
            }
            else{
                ans=ans*10+dig1;
            }
        }
        if(ans%10==8){
            ans = ans-ans%10-1;
        }
        return ans;

    }
}
