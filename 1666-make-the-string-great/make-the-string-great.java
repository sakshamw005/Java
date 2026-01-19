class Solution {
    public String makeGood(String s) {
        if(s.length()==1)return s ;
        Stack<Character> st = new Stack<>() ;
        for(char x : s.toCharArray()){
            if(!st.isEmpty() && Math.abs(x-st.peek())==32){
                st.pop() ;
            }
            else{
                st.push(x) ;
            }
        }
        StringBuilder ans = new StringBuilder() ;
        while(!st.isEmpty()){
            ans.append(st.pop()) ;
        }
        return ans.reverse().toString() ;
    }
}