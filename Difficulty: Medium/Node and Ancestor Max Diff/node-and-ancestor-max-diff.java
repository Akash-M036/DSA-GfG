/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int ans = Integer.MIN_VALUE;
    public void dfs(Node root,int maxanc){
        if(root== null) return;
            maxanc = Math.max(maxanc,root.data);
        if(root.left!=null){
            ans = Math.max(ans, maxanc-root.left.data);
        dfs(root.left,maxanc);
        }
        if(root.right!=null){
            ans = Math.max(ans, maxanc-root.right.data);
        dfs(root.right,maxanc);
        }
        
    }
    int maxDiff(Node root) {
        dfs(root,root.data);
        return ans;
    }
}