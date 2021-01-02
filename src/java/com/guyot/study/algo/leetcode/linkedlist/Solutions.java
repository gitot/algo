package com.guyot.study.algo.leetcode.linkedlist;

import com.guyot.study.algo.leetcode.ListNode;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 链表
 * @date 2021/1/1
 */
public class Solutions {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                break;
            }
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a == null) a = headB;
            if (b == null) b = headA;
            a = a.next;
            b = b.next;
        }
        return headA;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }
}

