package com.guyot.study.algo.leetcode.linkedlist;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 单链表
 * @date 2020/12/30
 */
public class MyLinkedList {
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = new Node(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cur = head.next;
        for (int i = 0; i <= index && cur != null; cur = cur.next, i++) {
            if (i == index) return cur.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node prev = head;
        for (; prev.next != null; prev = prev.next) ;
        prev.next = new Node(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node prev = head;
        for (int i = 0; prev != null && i <= index; prev = prev.next, i++) {
            if (i == index) {
                Node node = new Node(val);
                node.next = prev.next;
                prev.next = node;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node prev = head;
        for (int i = 0; prev != null && prev.next != null && i <= index; prev = prev.next, i++) {
            if (i == index) {
                prev.next = prev.next.next;
            }
        }
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
    }
}
