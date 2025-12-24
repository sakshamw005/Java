class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = 0 ;
        for(int i : apple)n+=i ;
        Arrays.sort(capacity) ;
        int ans = 0 ;
        for (int i = capacity.length - 1; i >= 0; i--) {
            n -= capacity[i];
            ans++;
            if (n <= 0) {
                break;
            }
        }
        return ans ;
    }
}