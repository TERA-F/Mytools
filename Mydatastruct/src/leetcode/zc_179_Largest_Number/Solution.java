public class Solution {
    public String largestNumber(int[] nums) {
/*        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int minlen = Math.min(s1.length(),s2.length());
                for(int i = 0 ; i < minlen; i++){
                    if(s1.charAt(i)>s2.charAt(i))
                        return -1;
                    else if(s1.charAt(i)<s2.charAt(i))
                        return 1;
                }
                if(s1.length() > minlen){
                    if(s1.charAt(minlen)>'0')
                        return -1;
                    else
                        return 1;
                }
                if(s2.length() > minlen){
                    if(s2.charAt(minlen)>'0')
                        return 1;
                    else
                        return -1;
                }
                return 0;
            }
            
        });
        for(int x: nums)
            pq.add(x+"");
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();*/ //wrong solution for [121,12]
        if(nums == null || nums.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    s_num[i] = String.valueOf(nums[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	        };
		
		Arrays.sort(s_num, comp);
                // An extreme edge case by lc, say you have only a bunch of 0 in your int array
                if(s_num[0].charAt(0) == '0')
                    return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	            sb.append(s);
		
		return sb.toString();
    }
}
