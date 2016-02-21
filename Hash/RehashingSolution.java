/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//from lintcode
public class RehashingSolution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0){
            return null;
        }
        int n = hashTable.length * 2;
        ListNode[] table = new ListNode[n];
        for (ListNode node : hashTable){
            if (node == null){
                continue;
            }
            //rehash each elt. on the chain 
            ListNode p = node;
            while(p != null){
                int index = (p.val % n + n) % n;
                ListNode q = new ListNode(p.val);
                //need to insert to the end of the chain
                ListNode x = table[index];
                if(x == null){
                    table[index] = q;
                }else{
                    while(x.next != null){
                        x = x.next;
                    }
                    x.next = q;
                }
                p = p.next;
            }
        }
        return table;
    }
};
