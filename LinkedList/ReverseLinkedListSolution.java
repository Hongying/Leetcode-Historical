/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
       /* //this can be omitted actually
       if(head == null || head.next == null){
           return head;
       }
       */
       ListNode prev = null;
       ListNode next;
       while(head != null){
           next = head.next;
           head.next = prev;
           prev = head;
           head = next;
       }
       return prev;
    }
}