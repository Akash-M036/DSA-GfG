class Solution { 
    public int bitonic(int[] arr) { 
        if (arr.length == 0 || arr.length == 1) return arr.length; 
        
        boolean inc = false; 
        boolean dec = false; 
        int maxlen = 1; 
        int curr = 1; 
        int plateau = 1; 
        
        for (int i = 0; i < arr.length - 1; i++) { 
            if (arr[i] == arr[i + 1]) { 
                curr++; 
                plateau++; 
            } 
            else if (arr[i] < arr[i + 1]) { 
                inc = true; 
                if (dec) { 
                    curr = plateau + 1; 
                    dec = false; 
                } else {
                    curr++; 
                }
                plateau = 1; 
            } 
            else if (arr[i] > arr[i + 1]) { 
                dec = true; 
                if (inc) { 
                    inc = false; 
                } 
                curr++; 
                plateau = 1; 
            } 
            maxlen = Math.max(curr, maxlen); 
        } 
        return maxlen; 
    } 
}
