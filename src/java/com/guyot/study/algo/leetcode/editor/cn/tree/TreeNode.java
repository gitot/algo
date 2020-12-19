package com.guyot.study.algo.leetcode.editor.cn.tree;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc Definition for a binary tree node.
 * @date 2020/12/19
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
