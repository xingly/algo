package tree;


import java.util.*;

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
     * 创建一颗树
     * @param arr
     * @return
     */
    private static TreeNode create(Integer[] arr, int n) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == null) {
                nodes[i] = null;
            }else {
                nodes[i] = new TreeNode(arr[i]);
            }
        }

        for(int i = 0; i < n; i++){
            if (nodes[i] == null) {
                continue;
            }

            int indexLeft = i * 2 + 1;
            if (indexLeft < n) {
                nodes[i].left = nodes[indexLeft];
            }

            int indexRight = i * 2 + 2;
            if (indexRight < n) {
                nodes[i].right = nodes[indexRight];
            }
        }
        return nodes[0];
    }

    /**
     * @link https://leetcode-cn.com/problems/linked-list-in-binary-tree/
     *
     * @description 二叉树中的列表
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

    /**
     * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * @Description 二叉树层序遍历
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> curList = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                curList.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(curList);
        }

        return result;
    }

    /**
     * @link https://leetcode-cn.com/problems/binary-tree-right-side-view/
     *
     * @Description 二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = queue.poll();
                if(i == sz - 1){
                    list.add(cur.val);
                }

                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }

        return list;
    }

    /**
     * @link https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
     *
     * @Description 二叉树的锯齿形层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack();
        int deepth = 1;

        queue.offer(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> curList = new ArrayList<>();
            for(int i = 0; i < sz; i++){
                TreeNode cur = queue.poll();
                if(deepth % 2 == 1){
                    curList.add(cur.val);
                }else{
                    stack.push(cur.val);
                }

                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

            while(!stack.isEmpty()){
                curList.add(stack.pop());
            }

            result.add(curList);

            deepth++;
        }

        return result;
    }

    /**
     * 对称二叉树
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            if (depth > 0 && sz % 2 == 1) {
                return false;
            }

            Integer[] arr = new Integer[sz];
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                arr[i] = cur.val;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if(!isSymmetric(arr)){
                return false;
            }

            depth++;
        }

        return true;
    }

    private static boolean isSymmetric(Integer[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, null, 3, null, 3};
        TreeNode root = create(arr, arr.length);

        // 二叉树中的列表
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(6);
//        boolean flag = isSubPath(head, root);
//        System.out.println(flag);

        // 二叉树层序遍历
//        List<List<Integer>> result = levelOrder(root);
//        System.out.println(result.toString());

        // 对称二叉树
        boolean res = isSymmetric(root);
        System.out.println(res);

    }


}
