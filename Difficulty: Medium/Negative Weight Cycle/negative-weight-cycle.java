// class Solution {
//     boolean ans =false;
//     public void bfs(int start, ArrayList<ArrayList<int[]>> adj,int V){
//         boolean[] vis = new boolean[V];
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{start,0});
//         while(!q.isEmpty()){
//             int tocheck =0;
//             int[] val = q.poll();
//             int cost = val[1];
//             for(int[] ch : adj.get(val[0])){
//                 int next = ch[0];
//                 int c = ch[1];
//                 if(vis[next]){
//                     if(cost<0)
//                         ans =true;
//                 }
//                 if(!vis[next]){
//                     q.offer(new int[]{next,c+cost});
//                 }
                
//             }
//         }
//     }
//     public boolean isNegativeWeightCycle(int V, int[][] edges) {
//         ArrayList<ArrayList<int[]>> adj = new ArrrayList<>();
//         for(int i =0; i< V;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] a : edges){
//             adj.get(a[0]).add(new int[]{a[1],a[2]});
//         }
//         for(int i =0; i< V;i++){
//             bfs(i,adj,V);
//         }
//         return ans;
        
//     }
// }
class Solution {
    boolean ans = false;

    public void bfs(ArrayList<ArrayList<int[]>> adj, int V){
        int[] minCost = new int[V];
        Arrays.fill(minCost, 0);

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            q.offer(new int[]{i, 0, 0});
        }

        while(!q.isEmpty()){
            int[] val = q.poll();
            int cost = val[1];
            int depth = val[2];

            if(depth >= V) {
                ans = true;
                return;
            }

            for(int[] ch : adj.get(val[0])){
                int next = ch[0];
                int c = ch[1];
                int nextCost = cost + c;

                if(nextCost < minCost[next]){
                    minCost[next] = nextCost;
                    q.offer(new int[]{next, nextCost, depth + 1});
                }
            }
        }
    }

    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a : edges){
            adj.get(a[0]).add(new int[]{a[1], a[2]});
        }

        bfs(adj, V);

        return ans;
    }
}
