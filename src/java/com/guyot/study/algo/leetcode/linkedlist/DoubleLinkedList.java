package com.guyot.study.algo.leetcode.linkedlist;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 双向链表
 * @date 2021/1/2
 */
public class DoubleLinkedList {
    private Node head;
    private int size;
    private Node tail;
    /** Initialize your data structure here. */

    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > size - 1) return -1;
        Node cur = head.next;
        for (int i = 0;cur != null && i <= index; i++,cur = cur.next) {
            if (i == index) return cur.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node cur = new Node(val);

        cur.next = head.next;
        cur.prev = head;
        cur.prev.next = cur;
        cur.next.prev = cur;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);

        cur.next = tail;
        cur.prev = tail.prev;
        cur.prev.next = cur;
        cur.next.prev = cur;

        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node prev = head;
        for (int i = 0;prev != null && i <= index; i++,prev = prev.next) {
            if (i == index) {
                Node cur = new Node(val);
                cur.prev = prev;
                cur.next = prev.next;
                cur.prev.next = cur;
                cur.next.prev = cur;

                size++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size - 1) return;
        Node cur = head.next;
        for (int i = 0;cur != null && i <= index; i++,cur = cur.next) {
            if (i == index) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

                size--;
            }
        }
    }

    class Node {
        int val;
        Node prev,next;

        public Node(int value) {
            this.val = value;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }
}
