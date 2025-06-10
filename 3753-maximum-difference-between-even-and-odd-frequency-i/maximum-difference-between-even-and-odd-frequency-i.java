class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> m = new HashMap<>() ;
        for(char x : s.toCharArray())m.put(x,m.getOrDefault(x,0)+1) ;
        int a1 = 0 , a2 = Integer.MAX_VALUE ;
        for(int i : m.values()){
            if(i%2!=0){
                a1 = Math.max(a1,i) ;
            }
            else{
                a2 = Math.min(a2,i) ;
            }
        }
        return a1-a2 ;
    }
}