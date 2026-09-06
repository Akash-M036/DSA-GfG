class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        /*
        a.b+X= A.C
        X=
        0101
        1010
        1111
        -----
        11110
        
        
        */
        int n = arr.length;
       long totalSum = 0;

               // Loop through all 32 bit positions
               for (int i = 0; i < 32; i++) {
                   long count = 0;

                   // Count how many elements have the i-th bit set
                   for (int j = 0; j < n; j++) {
                       if ((arr[j] & (1 << i)) != 0) {
                           count++;
                       }
                   }

                   // Calculate pairs and multiply by bit value (1 << i)
                   long pairs = (count * (count - 1)) / 2;
                   totalSum += pairs * (1L << i);
               }

               return totalSum;
        
    }
}