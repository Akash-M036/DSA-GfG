
 class Solution {
     public static int gcd(int a, int b){
         if(b == 0)
             return a;
         return gcd(b, a % b);
     }

     public int sameMod(int[] arr) {
         int gcd1 = 0;
         int st = 1;

         for(int i = 1; i < arr.length; i++){
             gcd1 = gcd(gcd1, Math.abs(arr[i] - arr[0]));
             if(arr[i] == arr[0])
                 st++;
         }

         if(st == arr.length)
             return -1;

         int ans = 0;

         for(int i = 1; i * i <= gcd1; i++){
             if(gcd1 % i == 0){
                 ans++;
                 if(i != gcd1/i)
                     ans++;
             }
         }

         return ans;
     }
 }
        // code here
   //     int fact =0;
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     for(int i =0; i< arr.length;i++){
    //         int x = arr[i];
    //         for(int j= 1; j*j<=x;j++){
    //             if(x%j==0){
    //             map.put(j,map.getOrDefault(j,0)+1);
    // //            fact++;
    //             }
    //             if(j != x/j){
    //             map.put(x/j,map.getOrDefault(x/j,0)+1);
    //   //          fact++;
    //             }
    //             }
            
    //     }
    //     boolean some =false;
    //     int ans =0;
    //     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
    //         int k = entry.getKey();
    //         int v = entry.getValue();
    //         if(v==arr.length)
    //             ans++;
    //         if(v<arr.length)
    //             some = true;
    //     }
    //     if(!some) return -1;
    //     return ans;
      //  if(fact== )
//     }
// }