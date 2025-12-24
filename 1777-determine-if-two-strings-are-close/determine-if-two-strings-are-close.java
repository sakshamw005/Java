class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false ;
        Map<Character,Integer> m = new HashMap<>() ;
        Map<Character,Integer> n = new HashMap<>() ;
        for(char x : word1.toCharArray())m.put(x,m.getOrDefault(x,0)+1) ;
        for(char x : word2.toCharArray())n.put(x,n.getOrDefault(x,0)+1) ;
        if (!m.keySet().equals(n.keySet())) return false;

        List<Integer> f1 = new ArrayList<>(m.values());
        List<Integer> f2 = new ArrayList<>(n.values());

        Collections.sort(f1);
        Collections.sort(f2);

        return f1.equals(f2);
    }
}