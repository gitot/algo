package com.guyot.study.algo.leetcode.editor.cn.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 二叉树序列化与反序列化
 * @date 2020/12/23
 */
public class Codec {

    public Codec() {
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(codec.serialize(root));
    }
}
