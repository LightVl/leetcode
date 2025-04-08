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
        Calc calc = new Calc(0, false);
        while (l1.next != null && l2.next != null) {
            calc = count(l1.val, l2.val, calc.perenos);
            current.next = new ListNode(calc.result);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        calc = count(l1.val, l2.val, calc.perenos);
        current.next = new ListNode(calc.result);
        current = current.next;
        if (calc.perenos && l1.next == null && l2.next == null)
            current.next = new ListNode(1);
        if (l1.next != null) {
            while (l1.next != null) {
                l1 = l1.next;
                calc = count(l1.val, 0, calc.perenos);
                current.next = new ListNode(calc.result);
                current = current.next;
            }
            if (calc.perenos)
                current.next = new ListNode(1);
        }
        if (l2.next != null) {
            while (l2.next != null) {
                l2 = l2.next;
                calc = count(0, l2.val, calc.perenos);
                current.next = new ListNode(calc.result);
                current = current.next;
            }
            if (calc.perenos)
                current.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    public record Calc(int result, boolean perenos) {
    }

    public static Calc count(int n1, int n2, boolean perenos) {
        int result = n1 + n2;
        if (perenos)
            result++;
        if (result > 9) {
            perenos = true;
            result = result % 10;
        } else
            perenos = false;
        return new Calc(result, perenos);
    }
}
