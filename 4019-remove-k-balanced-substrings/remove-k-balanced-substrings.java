class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Pair> st = new Stack<>() ;
        for(char x : s.toCharArray()){
            if(st.isEmpty())st.push(new Pair(x,1)) ;
            else{
                Pair g = st.peek() ;
                if(g.c==x){
                    g.count++ ;
                }
                else st.push(new Pair(x,1)) ;
            }
            while(st.size()>=2){
                Pair b = st.pop() , a = st.pop() ;
                if(a.c=='(' && b.c==')' && a.count>=k && b.count>=k ){
                    a.count-=k ;
                    b.count-=k ;
                    if (a.count > 0) st.push(a);
                    if (b.count > 0) st.push(b);
                }
                else {
                    st.push(a);
                    st.push(b);
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder() ;
        for(Pair p : st){
            for(int i = 0 ; i<p.count ; i++) ans.append(p.c) ;
        }
        return ans.toString() ;
    }
}
class Pair{
    char c ;
    int count ;
    Pair(char c ,int count ){
        this.c = c ;
        this.count = count ;
    } 
}