class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length ;
        int[] arr = new int[n] ;
        int ans = Integer.MIN_VALUE ;
        for(int i = energy.length-1 ; i>=0 ; i--){
            arr[i] = energy[i] + (i + k < n ? arr[i + k] : 0);
            ans = Math.max(ans,arr[i]) ;
        }
        return ans ;
    }
}