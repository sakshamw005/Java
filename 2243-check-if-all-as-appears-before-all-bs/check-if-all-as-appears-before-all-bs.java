class Solution {
    public boolean checkString(String s) {
        Stack<Character> st = new Stack<>() ;
        for(char x : s.toCharArray()){
            if(!st.isEmpty() && st.peek()=='b' && x=='a')return false ;
            st.push(x) ;
        }
        return true ;
    }
}