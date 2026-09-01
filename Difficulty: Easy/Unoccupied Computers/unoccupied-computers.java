class Solution {
    public int solve(int n, String s) {
        // code here
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> out = new HashSet<>();
        int ans =0;
        for(int i =0; i< s.length();i++){
           if(!set.contains(s.charAt(i))) {
               if(out.contains(s.charAt(i))){
                   continue;
               }
               if(n>0){
                   set.add(s.charAt(i));
                   n--;
               }
               else{
                   out.add(s.charAt(i));
                   ans++;
               }
           
              }
                 else{
                  n++;
           }
        }
        return ans;
    }
}
