class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0 , l = 0 , r = 0 ;
        Map<Integer,Integer> map = new HashMap<>() ;
        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1) ;
            while(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1) ;
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]) ;
                }
                l++ ;
            }
            ans = Math.max(ans,r-l+1) ;
            r++ ;
        }
        return ans ;
    }
}