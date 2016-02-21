public class LRUCache {
    public class Node{
        int key; 
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        head.next = head;
        head.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        } 
        //remove the node from the linked list, but not delete it 
        Node p = map.get(key);
        p.prev.next = p.next;
        p.next.prev = p.prev;
            
        //add it to the tail
        moveToTail(key);
        
        return map.get(key).value;
    }
    //least recently used: head.next
    public void set(int key, int value) {
        //get key alreay moves this node to the tail, just update the value
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        //if reached the full capacity and the element is not there, remove the first elt.
        if(map.size() == capacity){
            if(head.prev != head){
                map.remove(head.next.key);
                head.next.next.prev = head;
                head.next = head.next.next;
            }
        }

        //add the new elt. in the tail
        Node p = new Node(key, value);
        map.put(key,p);
        moveToTail(key);
    }
    
    public void moveToTail(int key){
        Node p = map.get(key);
        Node q = head.prev;
        head.prev = p;
        p.prev = q;
        q.next = p;
        p.next = head;
    }
}