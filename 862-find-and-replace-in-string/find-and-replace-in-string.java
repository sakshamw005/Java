class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i = 0 ; i < indices.length ; i++){
            if(s.startsWith(sources[i] , indices[i])){
                m.put(indices[i],i) ;
            }
        }
        StringBuilder ans = new StringBuilder() ;
        for(int i = 0 ; i<s.length() ;){
            if(!m.containsKey(i)){
                ans.append(s.charAt(i)) ;
                i +=1 ;
            }
            else{
                ans.append(targets[m.get(i)]) ;
                i = i + sources[m.get(i)].length() ;
            }
        }
        return ans.toString() ;
    }
}