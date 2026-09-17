/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int ans =Integer.MAX_VALUE;
    public int prev =-1;
    public void dfs(Node root){
        if(root==null)
            return ;
        
            
        // if(root.left==null && root.right==null )
        //     return root.data;
        // if(root.left!=null){
        //   int val = dfs(root.left.right);
        //     ans = Math.min(ans, root.data-val);
        // }
        // if(root.right!=null){
        //     int val = dfs(root.right.left);
        //      ans = Math.min(ans, val-root.data);
        // }
        dfs(root.left);
        if(prev!=-1){
        
         ans = Math.min(ans, root.data-prev);
        }
         prev =root.data;
        dfs(root.right);
        return ;
    }
    public int absDiff(Node root) {
        dfs(root);
        return ans;
    }
}
