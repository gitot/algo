package com.guyot.study.algo.leetcode.linkedlist;

import com.guyot.study.algo.leetcode.ListNode;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 链表
 * @date 2021/1/1
 */
public class LinkedListSolutions {
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
        while (fast != null) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }

            //相遇
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
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
        if (head == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode second = sentinel, first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return sentinel.next;
    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, tmp = null;
        while (cur != null) {
            //保存下一步处理节点
            tmp = cur.next;

            //处理当前节点
            cur.next = prev;

            //处理下一个节点
            prev = cur;
            cur = tmp;
        }
        return prev;
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        for (ListNode prev = sentinel, cur = head;
             cur != null;
             cur = cur.next) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }

        return sentinel.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        //偶数链表头节点
        ListNode b = head.next;
        ListNode odd = head, even = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = b;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //1.找到终点.  如果节点数据是奇数，slow位于终点，若为偶数slow位于后半段第一个节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //2.翻转后半部分
        ListNode prev = null, cur = slow, tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = tmp;
        }

        //3.比对
        for (ListNode left = head, right = prev;
             right != null;
             left = left.next, right = right.next) {
            if (left.val != right.val) return false;
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode(0),tail = res;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int cur = a + b + overflow;
            overflow = cur / 10;
            tail.next = new ListNode(cur % 10);
            tail = tail.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (overflow > 0) tail.next = new ListNode(overflow);

        return res.next;
    }



    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;


        //计算链表长度,将链表置为环
        int size = 1;
        ListNode cur = head;
        for (; cur != null && cur.next != null; cur = cur.next) {
            size++;
        }
        cur.next = head;

        //计算实际需要翻转的次数
        int newTailIndex = size - k % size - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++, newTail = newTail.next);
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
//        head.next.next = new ListNode(1);
        LinkedListSolutions solu = new LinkedListSolutions();
        boolean res = solu.isPalindrome(head);
        System.out.println(res);
    }
}

