// class Solution {
//     public void dfs(int idx,ArrayList<ArrayList<Integer>> adj ,boolean[] vis,Integer[] map){
//         if(vis[idx])
//             return;
//         map[idx]= (int)1e6;
//         vis[idx]=true;
//         for(int nei : adj.get(idx)){
//             dfs(nei,adj,vis,map);
//         }
//     }
//     public int ndfs(int idx,ArrayList<ArrayList<Integer>> adj ,boolean[] vis,Integer[] map){
//         if(vis[idx])
//             return 0;
//         int cnt = 0;
//         vis[idx]=true;
        
//         for(int nei : adj.get(idx)){
//           cnt = 1+ ndfs(nei,adj,vis,map);
//         }
        
//         if(map[idx]!=null){
//             map[idx]=Math.min(map[idx],cnt);
//         }
//         return cnt;
//     }
//     public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
//         // code here
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i =0; i<=n+1;i++){
//             adj.add(new ArrayList<>());
//         }
//         Integer[] map = new Integer[n+1];
//         for(int i =0;i<edges.length;i++){
//             int u = edges[i][0];
//             int v = edges[i][1];
//             adj.get(u).add(v);
//         }
//         boolean[] vis = new boolean[n+1];
//         dfs(src,adj,vis,map);
//         if(map[dst]!=null)
//             return 0;
//         vis = new boolean[n+1];
//         int ans =Integer.MAX_VALUE;
//         ndfs(dst,adj,vis,map);
//         for(int i =0; i<= n;i++){
//             if(map[i]!=null)
//                 ans = Math.min(map[i],ans);
                
//         }
//         return ans;
        
//     }
// }
import java.util.*;

class Solution {
    // A simple inner class to keep your style
    class Node {
        int val;
        int cost; // 0 for forward, 1 for reverse
        Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
    }

    public void dfs(int idx, ArrayList<ArrayList<Node>> adj, int currentCost, int[] minReversals) {
        // If we found a cheaper or equal way to get to this node already, stop
        if (minReversals[idx] <= currentCost) {
            return;
        }

        // Update the minimum reversals needed to reach this node
        minReversals[idx] = currentCost;

        // Traverse all connected neighbors (both forward and backward)
        for (Node nei : adj.get(idx)) {
            dfs(nei.val, adj, currentCost + nei.cost, minReversals);
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        // Using n + 1 size safely
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph: forward edges cost 0, reverse edges cost 1
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Node(v, 0)); // Forward
            adj.get(v).add(new Node(u, 1)); // Reverse
        }

        // Tracking array initialized to a large value
        int[] minReversals = new int[n + 1];
        Arrays.fill(minReversals, Integer.MAX_VALUE);

        // Run the traversal from the source node
        dfs(src, adj, 0, minReversals);

        // If dst was never reached, return -1, otherwise return the calculated cost
        return minReversals[dst] == Integer.MAX_VALUE ? -1 : minReversals[dst];
    }
}
