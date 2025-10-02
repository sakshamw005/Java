class Solution {
    public int maxBottlesDrunk(int n, int ex) {
        if(n<ex)return n ;
        int ans = n ;
        int em = n ;
        while(em>=ex){
            em-=ex ;
            ex++ ;
            ans++ ;
            em++ ;
        }
        return ans ;
    }
}