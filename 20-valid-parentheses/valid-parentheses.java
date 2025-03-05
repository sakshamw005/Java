class Solution {
    public boolean isValid(String s) {
        if(s.length()==1){
            return false ;
        }
        Stack<Character> st = new Stack<>() ;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i)) ;
            }
            else{
                if(st.isEmpty() || 
                   (s.charAt(i) == ')' && st.pop() != '(') || 
                   (s.charAt(i) == '}' && st.pop() != '{') || 
                   (s.charAt(i) == ']' && st.pop() != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty() ;
    }
}