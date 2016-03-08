/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedListIISolution {
    /*
    divide the list into 3 sublists, before m to n list, m to n list, after m to n list
    reverse the m to n list
    connect the 3 sublists
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;  
        ListNode p= dummy;   //to go over the list     
        ListNode preM = null;
        
        for(int i = 0; i < m; i++){
            if(p != null){
                preM = p;
                p = p.next;
            }else{
                return null;
            }
        }
        
        ListNode mNode = p;
        preM.next = null;
        ListNode pre = null, next = null;
        ListNode postN = null;
        //note here the initialization; deal with case m == n
        if(p != null) {
            next = p.next;
            postN = p.next;
        }
       
       // note here: loop n - m + 1 times. e.g. m = 1, n = 2; first p stop at 1st node;
        //i is from 0 to 1, so it changes 2 nodes' next pointers
        for(int i = 0; i<n-m+1; i++){
            if(p != null){
                next=p.next;
                p.next=pre;
                pre = p;
                p = next;
                postN = p;
            }else{
                return null;
            }
        }
        //pre stops where the last elt. whose next pointer is changed
        preM.next = pre;
        mNode.next = postN;
        return dummy.next;
    }
}