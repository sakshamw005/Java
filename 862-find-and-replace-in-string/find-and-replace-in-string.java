class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                int idx = map.get(i);
                ans.append(targets[idx]);
                i += sources[idx].length() - 1;  
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}