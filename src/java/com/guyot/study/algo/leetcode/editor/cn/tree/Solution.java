package com.guyot.study.algo.leetcode.editor.cn.tree;

import java.util.*;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc Solutions related to tree structure
 * @date 2020/12/19
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                res.add(treeNode.val);
                root = treeNode.right;
            }
        }
        return res;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                root = treeNode.right;
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode treeNode = stack.peek();
                root = treeNode.right;
            }
            if (root == null) {
                res.add(stack.pop().val);
            }
        }
        return res;
    }


    public int[] findMode(TreeNode root) {
        return null;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    public boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && low >= root.val) || (high != null && high <= root.val)) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recursive(root.left, root.right);
    }

    private boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);

            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftTree;
                    cur.right = rightTree;
                    list.add(cur);
                }
            }

        }
        return list;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode treeNode = q.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) q.offer(treeNode.left);
                if (treeNode.right != null) q.offer(treeNode.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode treeNode = q.poll();
                if (res.size() % 2 == 0) {
                    tmp.offerLast(treeNode.val);
                } else {
                    tmp.offerFirst(treeNode.val);
                }
                if (treeNode.left != null) q.offer(treeNode.left);
                if (treeNode.right != null) q.offer(treeNode.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }


}
