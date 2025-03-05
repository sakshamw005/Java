class Solution {
    public int calPoints(String[] operations) {
        int sum = 0 ;
        Stack<Integer> st = new Stack<>() ;
        for(int i = 0 ; i<operations.length ; i++){
            String c = operations[i] ;
            if(c.equals("+")){
                int num1 = st.pop() ;
                int num2 = st.peek() ;
                st.push(num1) ;
                st.push(num1+num2) ;
            }
            else if(c.equals("D")){
                int x = st.peek() ;
                st.push(2*x) ;
            }
            else if(c.equals("C")){
                st.pop() ;
            }
            else{
                int a = Integer.parseInt(c) ;
                st.push(a) ;
            }
        }
        for(int i : st){
            sum+=i ;
        }
        return sum ;
    }
}