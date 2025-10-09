class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length ;
        int[] ans = new int[n] ;
        Arrays.sort(potions) ;

        for(int i = 0 ; i<spells.length ; i++){
            int idx = find(spells[i] , potions , success) ;
            if(idx!=-1){
                ans[i] = (potions.length-idx) ;
            }
        }
        return ans ;
    }
    public int find(int ele , int[] potions , long upper){
        int low = 0 , high = potions.length - 1 ;
        int idx = -1 ;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if((long)ele*potions[mid]>=upper){
                idx = mid ;
                high = mid - 1;
            }
            else{
                low = mid + 1 ;
            }
        }
        return idx ;
    }
}