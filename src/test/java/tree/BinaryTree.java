package tree;

public class BinaryTree {

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }




    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
