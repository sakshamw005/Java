class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> m = new HashMap<>() ;
        for(char x : s.toCharArray()){
            m.put(x,m.getOrDefault(x,0)+1) ;
        }
        List<Character> characters = new ArrayList<>(m.keySet());
        characters.sort((a, b) -> m.get(b) - m.get(a));
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            int frequency = m.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }
        return result.toString() ;
    }
}