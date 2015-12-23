import java.util.Hashtable;
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointerSolution {
    //version 1: use hashmap
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        Hashtable<RandomListNode, RandomListNode> table = new Hashtable<>();
        table.put(head, new RandomListNode(head.label));
        RandomListNode p = head;
        while(p != null){
            if(p.next != null){
                if(!table.containsKey(p.next)){
                    table.put(p.next, new RandomListNode(p.next.label));
                }
                table.get(p).next = table.get(p.next);
            }

            if(p.random != null){
                if(!table.containsKey(p.random)){
                    table.put(p.random, new RandomListNode(p.random.label));
                }
                table.get(p).random = table.get(p.random);
            }
            p = p.next;
        }
        return table.get(head);
    }
    
    /*
    //version 2: no hashtable to keep relationships between nodes
    //第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。 然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy， 拆分节点, 一边扫描一边拆成两个链表，这里用到两个dummy node。第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3` 
    //create nodes and copy next pointers
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    //copy random pointers
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    //split the list
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    */
}