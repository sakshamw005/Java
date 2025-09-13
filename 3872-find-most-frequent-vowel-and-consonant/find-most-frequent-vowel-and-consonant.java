class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> map = new HashMap<>() ;
        for(char x : s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1) ;
        }
        int vo = 0 , co = 0 ;
        for(char x : map.keySet()){
            if(isVowel(x)){
                vo = Math.max(vo,map.get(x)) ;
            }
            else{
                co = Math.max(co,map.get(x)) ;
            }
        }
        return vo+co ;
    }
    public boolean isVowel(char x){
        return (x=='a' || x=='e' || x=='i' || x=='o' || x =='u') ;
    }
}