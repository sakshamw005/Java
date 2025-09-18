class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length , ans = 0 ;
        for(int i : nums){
            ans+=i ;
        }
        int p1 = Optimal_Game_Strategy(nums,0,n-1) ;
        return p1*2>=ans ;
    }
    public static int Optimal_Game_Strategy(int[] arr , int i , int j){
        if(i>j){
            return 0 ;
        }
        int f = arr[i]+Math.min(Optimal_Game_Strategy(arr,i+2,j) , Optimal_Game_Strategy(arr,i+1,j-1)) ;
        int s = arr[j]+Math.min(Optimal_Game_Strategy(arr,i+1,j-1) , Optimal_Game_Strategy(arr,i,j-2)) ;
        return Math.max(f,s) ;
    }
}