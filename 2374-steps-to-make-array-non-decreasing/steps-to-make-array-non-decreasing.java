class Solution {
    public int totalSteps(int[] nums) {
        Stack<Pair> st = new Stack<>() ;
        int ans = 0 ;
        for(int i = nums.length-1 ; i>=0 ; i--){
            int cnt = 0 ;
            while(!st.isEmpty() && nums[i]>st.peek().ele){
                cnt = Math.max(cnt+1,st.peek().val);
                st.pop() ;
            }
            ans = Math.max(cnt,ans) ;
            st.push(new Pair(nums[i],cnt)) ;
        }
        return ans ;
    }
    class Pair{
        int ele ;
        int val ;
        Pair(int ele , int val){
            this.ele = ele ;
            this.val = val ;
        }
    }
}