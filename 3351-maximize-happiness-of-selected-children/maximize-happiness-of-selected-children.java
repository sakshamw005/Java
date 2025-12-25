class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0 ;
        Arrays.sort(happiness) ;
        int x = 0 ;
        for(int i = happiness.length-1 ; i >= 0 && k > 0; i--){
            int temp = happiness[i] - x;
            if (temp > 0) {
                ans += temp;
            }
            x++;
            k--;
        }
        return ans;
    }
}