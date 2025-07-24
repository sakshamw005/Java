class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder st = new StringBuilder() ;
        int depth = 0 ;
        for(char x : s.toCharArray()){
            if(x=='('){
                if(depth>0){
                    st.append(x) ;
                }
                depth++ ;
            }
            else{
                depth-- ;
                if(depth>0){
                    st.append(x) ;
                }
            }
        }
        return st.toString() ;
    }
}