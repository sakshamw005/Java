class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = 0 ;
        for(int i : apple)n+=i ;
        Arrays.sort(capacity) ;
        int ans = 0 , i = capacity.length-1 ;
        while(n>0){
            n-=capacity[i] ;
            i-- ;
            ans++ ;
        }
        return ans ;
    }
}