/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int maxLen = 0;
    public int longestConsecutive(Node root) {
        if (root == null) {
            return -1;
        }
        traverse(root, root.data, 0);
        return maxLen > 1 ? maxLen : -1;
    }
    private void traverse(Node root, int target, int currentLen) {
        if (root == null) {
            return;
        }
        if (root.data == target) {
            currentLen++;
        } 
        else {
            currentLen = 1;
        }
        maxLen = Math.max(maxLen, currentLen);
        traverse(root.left, root.data + 1, currentLen);
        traverse(root.right, root.data + 1, currentLen);
    }
}
