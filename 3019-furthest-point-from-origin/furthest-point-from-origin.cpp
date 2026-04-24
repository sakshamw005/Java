class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int us = 0 , l = 0 , r = 0;
        for(char i : moves){
            if(i=='L')l++ ;
            else if(i=='R')r++ ;
            else us++ ;
        }
        return abs(r-l) + us ;
    }
};