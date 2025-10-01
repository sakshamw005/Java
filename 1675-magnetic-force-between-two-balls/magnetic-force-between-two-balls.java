class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position) ;
        int ans = 1 ;
        int l = 1 , r = (position[position.length-1] - position[0]) ;
        while(l<=r){
            int mid = l + (r-l)/2 ;
            if(possible(position,mid,m)){
                ans = mid ;
                l = mid + 1 ;
            }
            else{
                r = mid - 1 ;
            }
        }
        return ans ;
    }
    public boolean possible(int[] pos , int mid , int m){
        int c = 1 , r = pos[0] ;
        for(int i = 0 ; i<pos.length ; i++){
            if(pos[i] - r >=mid){
                c++ ;
                r = pos[i] ;
            }
            if(c>=m)return true ;
        }
        return false ;
    }
}