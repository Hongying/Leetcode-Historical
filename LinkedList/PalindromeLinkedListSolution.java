/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {
        //reverse the second half linked list, and compare with the first half
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // if use condition while(fast != null && fast.next != null), need to deal with head2 like the below
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse;
        /* deal with head2
        ListNode head2 = slow; //if even number of elements in the list
        if(fast != null){
            //odd number of elements
            head2 = slow.next; 
        }
        */ 
        ListNode head2 = slow.next;
        //head2 is the head of the second half, e.g. 1,2,3,4 head2 = 3; 1,2,3, head2 = 3; 1, 2, head2 = 2
        ListNode next;
        ListNode end = null; //e.g. ..., 1, 2, 3, then end = 1, head2 = 2, next = 3
        while(head2 != null){
            next = head2.next;
            head2.next = end;
            end = head2;
            head2 = next;
        }
        
        //compare
        //at last head2 == null, end is the new head of the 2nd half list
        head2 = end;
        while(head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }
}