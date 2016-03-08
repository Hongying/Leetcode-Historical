/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedListsSolution{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        //version 1: merge 2 lists (1st elt. and last elt.), then 2 lists (2nd and 2nd from end), etc, until there is only 1 left
        /*
        //it could also be: define left and right outside of the loop; while(end != 0)
        while(lists.length > 1){
            ListNode[] lists2 = new ListNode[(lists.length + 1) / 2];
            int left = 0;
            int right = lists.length - 1;
            while(left < right){
                lists2[left] = merge2Lists(lists[left],lists[right]);
                left++;
                right--;
            }
            //if lists's length is odd, put the middle element in lists2
            if(left == right){
                lists2[left] = lists[left];
            }
            lists = lists2;
        }
        return lists[0];
        */
        
        //version 1 variant: merge on the top of the original array
        int l = 0;
        int r = lists.length - 1; 
        while(r != 0){
            while(l < r){
                lists[l] = merge2Lists(lists[l],lists[r]);
                l++;
                r--;
            }
            l = 0; // r is the last elt. that should be merged in the next loop, thus no need to update
        }
        return lists[0];

        /* //version 1 variant 2: e.g. 0, 1, 2, 3. merge 0 and 2, 1 and 3, then 0 and 1.
        int n = lists.length;
        
        while(n > 1){
        for(int i = 0; i <= (n - 1) / 2; i++){
            if(i+ (n - 1) /2 + 1 < n){
                lists[i] = merge2lists(lists[i], lists[i+ (n - 1) /2 + 1]);
            }
        }
        n = (n - 1) / 2 + 1;
       }
        //VERSION 1 variant 3:    
        while(n > 1){
            for(int i = 0; i < (n + 1) / 2; i++){
                if((i + (n + 1) / 2) < n){
                    lists[i] = merge2lists(lists[i], lists[i+(n+1)/2]);
                }
            }
            n = (n + 1) / 2;
        }
        return lists[0];
        */
    
        /* version 2 using heap
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,
            new Comparator<ListNode>(){
                public int compare(ListNode n1, ListNode n2){
                    return n1.val - n2.val; 
                }
            });
        for(ListNode list : lists){
            if(list != null) {
                q.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(q.size() > 0){
            ListNode temp = q.poll();
            p.next = temp;
            p = p.next;
            if(temp.next != null){
                q.offer(temp.next);
            }
        }
        return head.next;
        */
        
        //version 3
        //return helper(lists, 0, lists.length - 1);
    }
    
        //version 1: merge 2 lists and return the head
        
    public ListNode merge2Lists(ListNode list1, ListNode list2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null){
            p.next = list1;
        }
        if(list2 != null){
            p.next = list2;
        }
        return head.next;
    }
    
        //version 3: divide and conquer 
        /*public ListNode helper(ListNode[] lists, int start, int end){
            if(start > end){
                return null;
            }
            if(start == end){
                return lists[start];
            }
            ListNode n1 = helper(lists, start, start + (end - start) / 2);
            ListNode n2 = helper(lists, start + (end - start) / 2 + 1, end);
            ListNode head = new ListNode(0);
            ListNode p = head;
            while(n1 != null && n2 != null){
                if(n1.val < n2.val){
                    p.next = n1;
                    n1 = n1.next;
                }else{
                    p.next = n2;
                    n2 = n2.next;
                }
                p = p.next;
            }
            if(n1 != null){
                p.next = n1;
            }
            if(n2 != null){
                p.next = n2;
            }
            return head.next;
        }
    */
}