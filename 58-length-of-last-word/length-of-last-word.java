class Solution {
    public int lengthOfLastWord(String s) {
        int c = 0;
        s = s.trim() ;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i)!=' ') {
            c++;
            i--;
        }
        return c;
    }
}
