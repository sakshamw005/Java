class Solution {
    public String smallestNumber(String pattern) {
        int[] ans = new int[pattern.length()+1] ;
        int count = 1 ;
        Stack<Integer> st = new Stack<>();
        for(int i =  0 ; i<=pattern.length() ; i++){
            if(i==pattern.length() || pattern.charAt(i) == 'I'){
                ans[i] = count++ ;
                while(!st.isEmpty()){
                    ans[st.pop()] = count++ ;
                }
            }
            else{
                st.push(i) ;
            }
        }
        String s = "" ;
        for(int v : ans){
            s = s + v ;
        }
        return s ;
    }
}