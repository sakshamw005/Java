class Solution {
    public int totalSteps(int[] nums) {
        int ans = 0 ;
        Stack<int[]> st = new Stack<>() ; //element , steps
        for(int i : nums){
            int s = 0 ;
            while(!st.isEmpty() && st.peek()[0] <= i){
                s = Math.max(s,st.peek()[1]) ;
                st.pop() ;
            }
            if(!st.isEmpty()){
                s++ ;
            }
            ans = Math.max(ans,s) ;
            st.push(new int[]{i,s}) ;
        }
        return ans ;
    }
}
// i = 0 : [{5,0}]
// i = 1 : [{3,1},{5,0}]
// i = 2 : []