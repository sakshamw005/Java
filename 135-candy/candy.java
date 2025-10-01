class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length] ;
        int curr = 1 ;
        for(int i = 0 ; i < ratings.length ; i++){
            if(i==0)ans[i] = curr ;
            else{
                if (ratings[i] > ratings[i - 1]) {
                    curr++;
                } else {
                    curr = 1; 
                }
                ans[i] = curr;
            }
        }
        curr = 1 ;
        for(int i = ratings.length-1 ; i>=0 ; i--){
            if(i==ratings.length-1)ans[i] = Math.max(ans[i],curr) ;
            else{
                if(ratings[i+1]<ratings[i]){
                    curr++ ;
                }
                else{
                    curr = 1 ;
                }
                ans[i] = Math.max(ans[i] , curr) ;
            }
        }
        int res = 0 ;
        for(int i : ans){
            res+=i ;
        }
        return res ;
    }
}