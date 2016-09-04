public class Solution {
    private static Set<Integer> visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!= s1.length()+s2.length())
            return false;
        visited = new HashSet<Integer>();
        return isInterleave(s1,0,s2,0,s3,0);
    }
    
    private boolean isInterleave(String s1, int l1, String s2, int l2, String s3, int l3){
        int hash = l1*s3.length()+l2;
        if(visited.contains(hash)){
            return false;
        }
        
        if(l1 == s1.length())
            return s2.substring(l2).equals(s3.substring(l3));
        if(l2 == s2.length())
            return s1.substring(l1).equals(s3.substring(l3));
        
        if((s3.charAt(l3)==s1.charAt(l1) && isInterleave(s1,l1+1,s2,l2,s3,l3+1))
         ||(s3.charAt(l3)==s2.charAt(l2) && isInterleave(s1,l1,s2,l2+1,s3,l3+1)))
         return true;
         
        visited.add(hash);
        return false;
    }
}
