class Solution {
    public String makeLargestSpecial(String s) {
        List<String> results = new ArrayList<>();
        int count = 0; 
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : -1;
            if (count == 0) {
                String in = s.substring(start + 1, i);
                results.add("1" + makeLargestSpecial(in) + "0");
                start = i + 1;
            }
        }
        Collections.sort(results, Collections.reverseOrder());

        return String.join("", results);
    }
}