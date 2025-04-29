class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> r = new HashMap<>() ;
        make(ransomNote,r) ;
        Map<Character,Integer> m = new HashMap<>() ;
        make(magazine,m) ;
        for (char c : r.keySet()) {
            if (m.getOrDefault(c, 0) < r.get(c)) {
                return false;
            }
        }
        return true;
    }
    public void make(String s,Map<Character,Integer> m){
        for(int i = 0 ; i<s.length() ; i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1) ;
        }
    }
}