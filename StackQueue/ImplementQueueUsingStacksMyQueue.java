class ImplementQueueUsingStacksMyQueue {
    /* //version 1 using stack to pop and peek
    Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        int n = stack.size();
        Stack<Integer> tempStack = new Stack<Integer>();
        helper(stack, tempStack, 1);
        stack.pop();
        helper(tempStack, stack, 0);
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tempStack = new Stack<Integer>();
        helper(stack, tempStack, 1);
        int x = stack.peek();
        helper(tempStack, stack, 0);
        return x;
    }
    
    //put stack1's (stack1.size() - n) element to stack2
    private void helper(Stack stack1, Stack stack2, int n){
        while(stack1.size() != n){
            stack2.push(stack1.pop());
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
    */
        //version 2: using both s1 and s2 to do peek and pop
        //for s1, elt. coming earlier is in the bottom; for s2, in the top; elt. in s2 comes earlier than elt. in s1
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();
        // Push element x to the back of queue.
        public void push(int x) {
            s1.push(x);
        }
        
        // Removes the element from in front of queue.
        public void pop() {
            if(!s2.empty()){
              s2.pop();
            }else{
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
                s2.pop();
            }
        }
        
        // Get the front element.
        public int peek() {
            if(!s2.empty()){
                return s2.peek();
            }else{
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
                return s2.peek();
            }
        }
        
        // Return whether the queue is empty.
        public boolean empty() {
            if(s1.empty()&&s2.empty()){
                return true;
            }else{
                return false;
            }
        }
}