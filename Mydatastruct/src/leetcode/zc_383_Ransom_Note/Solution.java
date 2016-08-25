public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charlist = new int[26];
        for(char x : magazine.toCharArray())
            charlist[x-'a']++;
        for(char x : ransomNote.toCharArray())
            if(--charlist[x-'a']<0) return false;
        return true;
    }
}
