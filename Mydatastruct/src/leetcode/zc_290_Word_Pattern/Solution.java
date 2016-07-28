public class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] list = str.split(" ");
        if(list.length!=pattern.length()) return false;
        int[] table = new int[256];
        HashSet<String> set = new HashSet();
        for(int i = 0 ; i < pattern.length() ; ++i)
            if(table[pattern.charAt(i)] == 0){
                table[pattern.charAt(i)] = i + 1;
                if(!set.add(list[i]))  return false;
            }
            else   if(!list[table[pattern.charAt(i)]-1].equals(list[i])) return false;
        return true;
    }
}
