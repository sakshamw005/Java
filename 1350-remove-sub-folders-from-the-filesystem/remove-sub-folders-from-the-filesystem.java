class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>() ;
        Arrays.sort(folder) ;
        ans.add(folder[0]);  
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(folder[i]);
            }
        }

        return ans ;
    }
}