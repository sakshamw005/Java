class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true ;
        }
        int count = 0 ;
        for(int i=0 ; i< flowerbed.length; i++){
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++ ;
                flowerbed[i] = 1 ;
                if(count==n){
                    return true ;
                }
            }
        }
        return false  ;
    }
}