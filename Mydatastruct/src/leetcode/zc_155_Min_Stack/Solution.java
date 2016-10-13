public class MinStack {

    private ArrayList<Integer> sta  = new ArrayList<Integer>();
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(min > x) min = x;
        sta.add(x);
    }
    
    public void pop() {
        int re = sta.remove(sta.size()-1);
        if(re == min) setmin();
    }
    
    public int top() {
        return sta.get(sta.size()-1);
    }
    
    public int getMin() {
        return min;
    }
    
    private void setmin(){
        min = Integer.MAX_VALUE;
        for(int i : sta)
            if(min>i) min = i;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
