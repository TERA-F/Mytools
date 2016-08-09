public class Solution {
    public int numSquares(int n) {
//a wrong answer
/*        if( n == 0 ) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        stack.push(1);
        
        while(!stack.empty()){
            while( stack.peek() <= n / stack.peek()){
                stack.add(stack.peek()+1);
            }
            // System.out.println(stack.peek());
            stack.pop();
            // System.out.println(n / stack.peek());
            while( stack.peek() <= n / stack.peek()){
                n -= stack.peek()*stack.peek();
                System.out.println("n:"+n);
                System.out.println("stack.peek():"+stack.peek());
                System.out.println("count:"+count);
                count++;
            }
            if(n == 0) break;
        }
        return count;*/
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 1; i <= n; ++i) {
    		int min = Integer.MAX_VALUE;
    		int j = 1;
    		while(i - j*j >= 0) {
    			min = Math.min(min, dp[i - j*j] + 1);
    			++j;
    		}
    		dp[i] = min;
    	}		
    	return dp[n];
    }
}
