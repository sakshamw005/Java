class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0 ;
        int h = weights[0] ;
        for(int i : weights){
            l = Math.max(i,l) ;
            h+=i ;
        }
        int ans = Integer.MAX_VALUE ;
        while(l<=h){
            int mid = l + (h-l)/2 ;
            if(isPossible(mid,weights,days)){
                ans = Math.min(ans,mid) ;
                h = mid - 1 ;
            }
            else{
                l = mid + 1 ;
            }
        }
        return ans ;
    }
    public static boolean isPossible(int mid , int[] weights ,  int d){
        int c = 0 , curr = 0 ;
        for(int i = 0 ; i<weights.length ; i++){
            int x = weights[i] ;
            if(curr+x<=mid){
                curr+=x ;
            }
            else{
                c++ ;
                curr = x ;
            }
        }
        return c+1<=d ;
    }
}