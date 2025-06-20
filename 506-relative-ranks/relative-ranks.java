class Solution {
    public String[] findRelativeRanks(int[] score) {
        int m = 0 ;
        for(int i : score) m = Math.max(m,i) ;
        int[] n = new int[m+1] ;
        for(int i = 0 ; i<score.length ; i++){
            n[score[i]] = i+1 ;
        }
        String[] res = new String[score.length] ;
        int r = 1 ;
        for(int i = m ; i>=0 ; i--){
            if(n[i]>0){
                int curr = n[i]-1 ;
                if(r==1){
                    res[curr] = "Gold Medal" ;
                }
                else if(r==2){
                    res[curr] = "Silver Medal" ;
                }
                else if(r==3){
                    res[curr] = "Bronze Medal" ;
                }
                else{
                    res[curr] = String.valueOf(r) ;
                }
                r++ ;
            }
        }
        return res;
    }
}