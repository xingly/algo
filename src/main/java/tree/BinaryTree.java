package tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @link https://leetcode-cn.com/problems/linked-list-in-binary-tree/
     *
     * @description linked-list-in-binary-tree
     */
    public static boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> curQueue = new LinkedList<>();
        int firstVal = head.val;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();

                if (cur.val == firstVal) {
                    curQueue.offer(cur);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (!curQueue.isEmpty()) {
                if (checkSubPath(curQueue, head)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkSubPath(Queue<TreeNode> queue, ListNode p) {

        while (!queue.isEmpty()) {
            int sz = queue.size();
            int j = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == p.val) {
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }else {
                    ++j;
                    if (j == sz) {
                        return false;
                    }
                }

            }

            if (p.next == null) {
                return true;
            }else {
                p = p.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nodes[i] = null;
            }else {
                nodes[i] = new TreeNode(arr[i]);
            }
        }

        TreeNode root = create(nodes);

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);

        boolean flag = isSubPath(head, root);
        System.out.println(flag);
    }


    private static TreeNode create(TreeNode[] nodes) {

        int len = nodes.length;

        for(int i = 0; i < len; i++){
            if (nodes[i] == null) {
                continue;
            }

            int indexLeft = i * 2 + 1;
            if (indexLeft < len) {
                nodes[i].left = nodes[indexLeft];
            }

            int indexRight = i * 2 + 2;
            if (indexRight < len) {
                nodes[i].right = nodes[indexRight];
            }
        }
        return nodes[0];
    }

}
