package tree;

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

        public BSTIterator(TreeNode root) {

        }

        /** @return the next smallest number */
        public int next() {

            return 1;

        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {

            return true;

        }
    }



}
