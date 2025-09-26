class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String key = getKey(strs[i]) ;
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>()) ;
            }
            map.get(key).add(strs[i]) ;
        }
        List<List<String>> list = new ArrayList<>();
        for(String s : map.keySet()){
            list.add(map.get(s)) ;
        }
        return list ;
    }
    public static String getKey(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch =  s.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(freq[i]).append('#'); 
        }
        return sb.toString();
    }
}