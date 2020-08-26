package tree;

import java.util.Stack;

public class BinarySearchTree {

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }

    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;
            TreeNode p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            return val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();

        }
    }



}
