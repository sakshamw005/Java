class Solution {
    static int MOD = 1_000_000_007 ;
    public int sumSubarrayMins(int[] arr) {
        long ans = 0 ;
        int n = arr.length ;
        int[] left = nse(arr) ;
        int[] right = pse(arr) ;
        for(int i = 0 ; i<n ; i++){
            long count = ((i - left[i])%MOD * (right[i] - i)%MOD)%MOD ;
            ans = (ans+(arr[i] * count)%MOD)%MOD ; 
        }
        return (int)ans ;
    }
    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}