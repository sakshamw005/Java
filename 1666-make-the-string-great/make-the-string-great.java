class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder() ;
        Stack<Character> st = new Stack<>() ;
        for(int i = 0 ; i<s.length() ; i++){
            if(!st.isEmpty() && Math.abs((st.peek()-'a')-(s.charAt(i)-'a'))==32){
                st.pop() ;
            }
            else{
                st.push(s.charAt(i)) ;
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop()) ;
        }
        return ans.reverse().toString();
    }
}