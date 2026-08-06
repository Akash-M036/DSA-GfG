import java.util.Arrays;

class Solution { 
    public int countMinOperations(int arr[]) { 
        Arrays.sort(arr);
        
        int cnt0 = 0; 
        int[] two = new int[arr.length]; 
        int[] ans1 = new int[arr.length]; 

        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] != 0) { 
                two[i] = (int)(Math.log(arr[i]) / Math.log(2)); 
            } else { 
                cnt0++; 
            } 
        } 

        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == 0) { 
                ans1[i] = 0; 
            } else if (arr[i] == 1) { 
                ans1[i] = 1; 
            } else { 
                ans1[i] = (int)Math.pow(2, two[i]); 
            } 
        } 
        
        int maxDoubles = 0;
        if (arr.length > 0) {
            maxDoubles = two[arr.length - 1]; 
        }

        int diff = maxDoubles; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            
            int rem = arr[i];
            while (rem > 0) {
                if (rem % 2 == 1) {
                    diff++; 
                }
                rem /= 2;
            }
        }

        return diff; 
    } 
}
