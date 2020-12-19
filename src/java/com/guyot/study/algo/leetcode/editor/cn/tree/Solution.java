package com.guyot.study.algo.leetcode.editor.cn.tree;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    public boolean isValidBST(TreeNode root,Integer low,Integer high) {
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
}
