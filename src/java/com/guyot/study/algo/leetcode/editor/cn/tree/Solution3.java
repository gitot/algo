package com.guyot.study.algo.leetcode.editor.cn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 路径和等于一个数字
 * @date 2020/12/21
 */
public class Solution3 {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursive(root, sum);
        return res;
    }

    private void recursive(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        recursive(root.left, target);
        recursive(root.right, target);
        path.removeLast();
    }


}
