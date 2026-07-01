class Solution { 
    static String longestPalindrome(String s) { 
        if (s == null || s.length() == 0) return "";
        
        int previdx = 0; 
        StringBuilder sb = new StringBuilder(""); 
        String ans = s.substring(0, 1); 
        String ans2 = ""; 
        
        for(int i = 0; i < s.length(); i++) { 
            previdx = i - 1; 
            int r = i; 
            
            while(previdx >= 0 && r < s.length() && s.charAt(r) == s.charAt(previdx)) { 
                sb.insert(0, s.charAt(r)); 
                sb.insert(sb.length(), s.charAt(previdx)); 
                
                previdx--; 
                r++; 
            } 
            
            if(ans.length() < sb.length()) ans = sb.toString(); 
            sb = new StringBuilder(""); 
        } 
        
        sb = new StringBuilder(""); 
        
        
        for(int i = 0; i < s.length(); i++) { 
            previdx = i - 1; 
            int r = i + 1;   
            
            sb = new StringBuilder(s.charAt(i) + ""); 
            
            while(previdx >= 0 && r < s.length() && s.charAt(r) == s.charAt(previdx)) { 
                sb.insert(0, s.charAt(r)); 
                sb.insert(sb.length(), s.charAt(previdx)); 
                
                previdx--; 
                r++; 
            } 
            
            if(ans2.length() < sb.length()) ans2 = sb.toString(); 
            sb = new StringBuilder(""); 
        } 
        
        if(ans2.length() > ans.length()) return ans2; 
        return ans; 
    } 
}