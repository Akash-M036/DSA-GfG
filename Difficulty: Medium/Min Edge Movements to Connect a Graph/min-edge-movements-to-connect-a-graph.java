class Solution {
    public void dfs(int idx , boolean[] vis,List<List<Integer>> adj ){
        if(vis[idx])
            return;
        vis[idx]=true;
        for(int nei : adj.get(idx)){
            dfs(nei,vis,adj);
        }
    }
    int minEdgesReq(int n, int[][] edges) {
        if(edges.length < n-1)
            return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i< n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans =-1;
        boolean[] vis = new boolean[n];
        for(int i =0; i< n;i++){
            if(!vis[i]){
                ans++;
                dfs(i,vis,adj);
            }
        }
        return ans;
    }
}