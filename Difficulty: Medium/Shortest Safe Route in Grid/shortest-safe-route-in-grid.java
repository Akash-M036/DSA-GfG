class Solution {
    // public int steps(int i , int j , int[][] mat, boolean[][] visited){
    //     if(i<0 || j<0 || i>=mat.length)
    //         return Integer.MAX_VALUE;
    //     if( j>=mat[i].length)
    //         return 0;
    //     if(mat[i][j]==0 || visited[i][j])
    //         return Integer.MAX_VALUE;

    //     visited[i][j] = true;
        
    //     int right = steps(i, j+1, mat, visited);
    //     int left = steps(i, j-1, mat, visited);
    //     int up = steps(i-1, j, mat, visited);
    //     int down = steps(i+1, j, mat, visited);
        
    //     visited[i][j] = false;

    //     if(right != Integer.MAX_VALUE) right = 1 + right;
    //     if(left != Integer.MAX_VALUE) left = 1 + left;
    //     if(up != Integer.MAX_VALUE) up = 1 + up;
    //     if(down != Integer.MAX_VALUE) down = 1 + down;

    //     int ans1 = Math.min(right, left);
    //     int ans2 = Math.min(up, down);
        
    //     return Math.min(ans1, ans2);
    // }
    int[] dirx = {1,0,-1,0};
    int[] diry = {0,1,0,-1};
    
    int shortestPath(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return -1; 
        }
        int n = mat.length;
        int m = mat[0].length;
         for(int i =0; i< n;i++){
            for(int j=0; j<m;j++){
                if(mat[i][j]==0)
                {
                   if(i >= 1 && mat[i-1][j] == 1)   mat[i-1][j] = 2;
                    if(i < n-1 && mat[i+1][j] == 1)  mat[i+1][j] = 2;
                    if(j >= 1 && mat[i][j-1] == 1)   mat[i][j-1] = 2;
                    if(j < m-1 && mat[i][j+1] == 1)  mat[i][j+1] = 2;
                }
            }
        }
        for(int i =0; i< n;i++){
            for(int j=0; j<m;j++){
                if(mat[i][j]==2)
                    mat[i][j]=0;
                
            }
        }
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(mat[i][0]==1){
            q.offer(new int[]{i,0,1});
             visited[i][0] = true;
            }
        }
       
        while(!q.isEmpty()){
            int[] x = q.poll();
            int l = x[0];
            int j =x[1];
            int steps =x[2];
            if(j==m-1)
                return steps;
            for(int i =0; i<4;i++){
                int newx = l+dirx[i];
                int newy = j+diry[i];
                if(newx>=0 && newx<mat.length && newy>=0 && newy<mat[newx].length)
                    {
                        if(mat[newx][newy]==1&& !visited[newx][newy]){
                            visited[newx][newy] = true;
                            q.offer(new int[]{newx,newy,steps+1});
                        }
                    }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
