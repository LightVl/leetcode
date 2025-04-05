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
 //That solution works only while long represent of l1 and l2
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val ==0 && l1.next == null)
            return l2;
        if (l2.val ==0 && l2.next == null)
            return l1;
        long firstNum = l1.val;
        long secondNum = l2.val;
        int decimal = 1;
        while(l1.next!=null) {
            l1=l1.next;
            firstNum = firstNum + (long)Math.pow(10,decimal)*l1.val;
            decimal++;
        }
        System.out.println(firstNum);
        decimal = 1;
        while(l2.next!=null) {
            l2=l2.next;
            secondNum = secondNum + (long)Math.pow(10,decimal)*l2.val;
            System.out.println(secondNum);
            decimal++;
        }
        System.out.println(secondNum);
        long result = firstNum + secondNum;
        System.out.println(result);
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (result > 0) {
        System.out.println(result);
        System.out.println(result%10);
        long temp = result % 10;
        System.out.println((int)temp);
        current.next = new ListNode((int)temp);
        System.out.println(current.next.val);
        current = current.next;
        result /= 10;
        }
        return dummyHead.next;
    }
}
