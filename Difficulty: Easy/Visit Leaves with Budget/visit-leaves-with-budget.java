/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public void dfs(Node root,int h){
        
        if(root==null){
            return;
        }
         if(root.left == null && root.right==null)
            {
                arr.add(h+1);
            }
        dfs(root.left,h+1);
        dfs(root.right,h+1);
        return ;
    }
    public int getCount(Node root, int k) {
        dfs(root,0);
        if(root.left == null && root.right==null) return 1;
        Collections.sort(arr);
        int ans =0;
        for(int a : arr){
            if(k!=0){
                if(k-a>=0){
                    k-=a;
                    ans++;
                }
            }
        }
        return ans;
    }
}