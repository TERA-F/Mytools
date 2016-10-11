class MyQueue {
    Stack<Integer> sta1 = new Stack<Integer>();
    Stack<Integer> sta2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        sta1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!sta1.empty())
            sta2.push(sta1.pop());
        sta2.pop();
        while(!sta2.empty())
            sta1.push(sta2.pop());
    }

    // Get the front element.
    public int peek() {
        while(!sta1.empty())
            sta2.push(sta1.pop());
        int i = sta2.peek();
        while(!sta2.empty())
            sta1.push(sta2.pop());
        return i;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sta1.empty();
    }
}
