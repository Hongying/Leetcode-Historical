/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode prev = p; //the node fall behind of p, to get the pointer if # of elt. is even
        boolean pIsOdd = false; //to record whether the number of elements is odd
        while(p.next != null){
            prev = p;
            ListNode temp = p.next;
            p.next = p.next.next;
            p = temp;
            pIsOdd = !pIsOdd;
        }
        //odd number of elements
        if(pIsOdd){
            p.next = dummy.next;
        }else{
            prev.next = dummy.next;
        }
        return head;
    }
}