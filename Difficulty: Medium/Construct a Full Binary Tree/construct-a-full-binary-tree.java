/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public boolean check(int v1, int v2, int t1,int t2){
        if(v1<v2 && t1<t2)
            return true;
        else if(v1>v2 && t1>t2)
            return true;
        return false;
    }
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        HashMap<Integer,Integer> pre1 = new HashMap<>();
        HashMap<Integer,Integer> prem1 = new HashMap<>();
        HashMap<Integer,Node> tree = new HashMap<>();
        for(int i = 0; i<pre.length;i++){
            pre1.put(pre[i],i);
        }
        for(int i = 0; i<pre.length;i++){
            prem1.put(preMirror[i],i);
        }
        for(int i = 0; i<pre.length;i++){
            int val = pre[i];
            tree.computeIfAbsent(pre[i],k-> new Node(val));
        }
        for(int i = 0; i<pre.length;i++){
           Node n1 = tree.get(pre[i]);
           int getidx = prem1.get(pre[i]);
           boolean first = false;
           if(i<pre.length-1 )
            first = check(i,i+1,prem1.get(pre[i]),prem1.get(pre[i+1]));
           if(first && i<pre.length-1 )
           {
               n1.left = tree.get(pre[i+1]);
           }
           
           if(first && getidx < pre.length-1){
               n1.right = tree.get(preMirror[getidx+1]);
           }
        }
        return tree.get(pre[0]);
    }
}