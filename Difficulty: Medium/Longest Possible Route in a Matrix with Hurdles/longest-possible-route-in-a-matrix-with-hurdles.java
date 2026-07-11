class Solution {
    int len = 0;
    boolean fin= false;
    public void dfs(int[][] mat,int i,int j, int fi, int fj,int l,boolean[][] vis){
        if(i==mat.length || i<0 || j<0 || j==mat[0].length || mat[i][j]==0)
            return;
        if(vis[i][j])
            return;
        if(i==fi && j==fj){
            len= Math.max(l,len);
            fin=true;
            return;
        }
        vis[i][j]= true;
        dfs(mat,i+1,j,fi,fj,l+1,vis);
        dfs(mat,i-1,j,fi,fj,l+1,vis);
        dfs(mat,i,j+1,fi,fj,l+1,vis);
        dfs(mat,i,j-1,fi,fj,l+1,vis);
        vis[i][j]=false;
        
    }
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        dfs(mat,xs,ys,xd,yd,0,vis);
        if(!fin)
            return -1;
        else
            return len;
    }
}