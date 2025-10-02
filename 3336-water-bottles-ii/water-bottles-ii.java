class Solution {
    public int maxBottlesDrunk(int n, int ex) {
        if(n<ex)return n ;
        int ans = n ;
        int em = n ;
        n = 0 ;
        while(n>0 || em>=ex){
            if(em>=ex){
                em-=ex ;
                n++ ;
                ex++ ;
            }
            if(n>0){
                ans+= n-- ;
                em++ ;
            }
        }
        return ans ;
    }
}