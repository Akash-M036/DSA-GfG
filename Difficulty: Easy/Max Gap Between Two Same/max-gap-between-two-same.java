class Solution {
    public int maxCharGap(String s) {
      HashMap<Character,Integer> map = new HashMap<>();
      int maxxdiff=-1;
      for(int i =0; i< s.length();i++){
          if(map.getOrDefault(s.charAt(i),-1)==-1){
          map.put(s.charAt(i),i);
          }
          else{
              maxxdiff =Math.max(maxxdiff, i-map.get(s.charAt(i))-1);
            //   map.put(s.charAt(i),i);
          }
      }
      
        return maxxdiff;
    }
}