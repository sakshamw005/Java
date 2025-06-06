class Solution {
    public String robotWithString(String s) {
        Stack<Character> st = new Stack<>() ;
        int[] freq = new int[26] ;
        for(char x : s.toCharArray()){
            freq[x-'a']++ ;
        }
        StringBuilder ans = new StringBuilder() ;
        for(char x : s.toCharArray()){
            st.push(x) ;
            freq[x-'a']-- ;
            while(!st.isEmpty() && st.peek()<=find(freq)){
                ans.append(st.pop()) ;
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop()) ;
        }
        return ans.toString() ;
    }
    private char find(int[] freq){
        for(int i = 0 ; i<26 ; i++){
            if(freq[i]>0){
                return (char)('a' + i) ;
            }
        }
        return (char)'z' + 1 ;
    }
}