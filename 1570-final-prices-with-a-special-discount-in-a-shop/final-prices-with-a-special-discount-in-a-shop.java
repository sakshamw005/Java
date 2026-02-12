class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = nse(prices);
        for(int i = 0 ; i<prices.length ; i++){
            ans[i] = prices[i] - ans[i] ;
        }
        return ans ;
    }
    public int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>() ;
        int[] ans = new int[arr.length] ;
        st.push(arr[arr.length-1]) ;
        for(int i = arr.length-2 ; i>=0 ; i--){
            while(!st.isEmpty() && st.peek()>arr[i]){
                st.pop() ;
            }
            ans[i] = st.isEmpty() ? 0 : st.peek() ;
            st.push(arr[i]) ;
        }
        return ans ;
    }
}