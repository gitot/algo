package com.guyot.study.algo.leetcode.editor.cn.tree;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 带属性的solution
 * @date 2020/12/21
 */
public class Solution2 {
    private int k;
    private int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    //翻转版中序遍历
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
