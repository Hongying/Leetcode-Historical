/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListSolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null){
            while(fast!=null && fast.val == slow.val){
                fast=fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return head;
    }
}