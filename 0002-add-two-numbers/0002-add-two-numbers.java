/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        boolean perenos = false;
        int result = 0;
        while (l1.next != null && l2.next != null) {
            result = l1.val + l2.val;
            if (perenos)
                result++;
            if (result > 9) {
                perenos = true;
                result = result % 10;
            } else
                perenos = false;
            current.next = new ListNode(result);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        result = l1.val + l2.val;
        if (perenos)
            result++;
        if (result > 9) {
            perenos = true;
            result = result % 10;
        } else
            perenos = false;
        current.next = new ListNode(result);
        current = current.next;
        if (perenos && l1.next == null && l2.next == null)
            current.next = new ListNode(1);
        if (l1.next != null) {
            while (l1.next != null) {
                l1 = l1.next;

                result = l1.val;
                if (perenos)
                    result++;
                if (result > 9) {
                    perenos = true;
                    result = result % 10;
                } else
                    perenos = false;
                current.next = new ListNode(result);
                current = current.next;
            }
            if (perenos)
                current.next = new ListNode(1);
        }
        if (l2.next != null) {
            while (l2.next != null) {
                l2 = l2.next;
                result = l2.val;
                if (perenos)
                    result++;
                if (result > 9) {
                    perenos = true;
                    result = result % 10;
                } else
                    perenos = false;
                current.next = new ListNode(result);
                current = current.next;
            }
            if (perenos)
                current.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}