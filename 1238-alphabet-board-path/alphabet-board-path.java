class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int r = 0, c = 0; 
        for (char ch : target.toCharArray()) {
            int nr = (ch - 'a') / 5;
            int nc = (ch - 'a') % 5;
            if (ch == 'z') {
                while (c > nc) { ans.append('L'); c--; }
                while (r > nr) { ans.append('U'); r--; }
                while (r < nr) { ans.append('D'); r++; }
            } else {
                while (r > nr) { ans.append('U'); r--; }
                while (c > nc) { ans.append('L'); c--; }
                while (r < nr) { ans.append('D'); r++; }
                while (c < nc) { ans.append('R'); c++; }
            }

            ans.append('!');
        }

        return ans.toString();
    }
}