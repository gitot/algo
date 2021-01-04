package com.guyot.study.algo.leetcode.linkedlist;

import com.guyot.study.algo.leetcode.ListNode;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 深拷贝
 * @date 2021/1/2
 */
public class CopyListNode {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node res = new Node(0),cur = res;
        while (head != null) {
            Node node = new Node(head.val);
            node.random = head.random;
            cur.next = node;
            cur = cur.next;
        }

        return res.next;
    }





    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
