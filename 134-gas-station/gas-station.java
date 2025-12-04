class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tg = 0 , tc = 0 ;
        for(int i = 0 ; i<gas.length ; i++){
            tg+=gas[i] ;
            tc+=cost[i] ;
        }
        if(tg<tc)return -1 ;
        int ans = 0 , x = 0 ;
        for(int i = 0 ; i<gas.length ; i++){
            x += gas[i] - cost[i] ;
            if(x<0){
                x = 0;
                ans = i+1 ;
            }
        }
        return ans ;
    }
}