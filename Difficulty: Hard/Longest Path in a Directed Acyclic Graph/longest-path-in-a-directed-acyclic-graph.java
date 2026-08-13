class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0; i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MIN_VALUE);
        dis[src]=0;
        for(int i =0; i< edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            adj.get(u).add(new int[]{v,w});
        }
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] val = pq.poll();
            int wt= val[1];
            int u =val[0];
            //if(vis[u])
              //  continue;
            //vis[u]=true;
            for(int[] v : adj.get(u)){
                if(dis[u]==Integer.MIN_VALUE) continue;
                if(dis[u]+v[1]>dis[v[0]]){
                    dis[v[0]]=dis[u]+v[1];
                    pq.add(new int[]{v[0],dis[v[0]]});
                }
            }
            }
            return dis;
    }
}
