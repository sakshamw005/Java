class Solution {
    public String maxValue(String n, int x) {
        char digit = (char)(x + '0');
        if (n.charAt(0) != '-') {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) < digit) {
                    return n.substring(0, i) + digit + n.substring(i);
                }
            }
            return n + digit;
        }
        else {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) > digit) {
                    return n.substring(0, i) + digit + n.substring(i);
                }
            }
            return n + digit;
        }
    }
}