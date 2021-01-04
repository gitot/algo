package com.guyot.study.algo.leetcode.linkedlist;

import com.sun.corba.se.spi.ior.IdentifiableFactory;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 双向链表题目
 * @date 2021/1/2
 */
public class DoubleLinkedListSolutions {

    /**
     * 将子级链表合并到当前链表之间
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    /*返回尾节点*/
    private Node helper(Node head) {
        if (head == null || head.next == null || head.child == null) return null;

        Node next = head.next;

        Node child = flatten(head.child);


        child.next = next;
        next.prev = child;

        return child;
    }



}
