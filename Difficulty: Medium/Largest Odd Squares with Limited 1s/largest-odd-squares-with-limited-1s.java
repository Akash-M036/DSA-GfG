class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        // code here
        int[][] pre = new int[mat.length][mat[0].length];
        for(int i = 0; i< mat.length; i++ ){
            pre[i][0]=mat[i][0];
        }
        for(int i = 0; i< mat.length; i++ ){
            for(int j = 1; j<mat[0].length;j++){
                pre[i][j]=pre[i][j-1]+mat[i][j];
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0; i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            // if (u < 0|| u >= mat.length || v < 0 || v >= mat[0].length) {
            //     arr.add(-1);
            //     continue;
            //     }
            int ans =-1;
            int startoddr = Math.min(u,Math.abs(mat.length-1-u));
            int startoddc = Math.min(v,Math.abs(mat[0].length-1-v));
            int st = Math.min(startoddr, startoddc);
            st = st*2+1;
             while(st>0 && ans<0){
                int end = st/2;
                int sum=0;
                for(int j = u-end; j<(u-end+st);j++){
                    int back = v-end >=1 ? pre[j][v-end-1] : 0;
                   sum += pre[j][v+end]-back;
                }
                if(sum<=k){
                    ans = st;
                }
                
                st-=2;
            }
            if(ans<0){
                arr.add(-1);
            }
            else
                arr.add(ans);
        }
        
            
            
        return arr;
    }
}