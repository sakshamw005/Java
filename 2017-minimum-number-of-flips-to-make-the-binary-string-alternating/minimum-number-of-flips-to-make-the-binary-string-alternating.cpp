class Solution {
public:
    int minFlips(string s) {
        int n = s.length();
        string ss = s + s;

        int x = 0, d = 0;
        int ans = n;

        for(int i = 0; i < ss.length(); i++) {
            if(ss[i] != (i % 2 ? '1' : '0')) x++;
            if(ss[i] != (i % 2 ? '0' : '1')) d++;
            if(i >= n) {
                if(ss[i-n] != ((i-n) % 2 ? '1' : '0')) x--;
                if(ss[i-n] != ((i-n) % 2 ? '0' : '1')) d--;
            }
            if(i >= n-1) {
                ans = min(ans, min(x, d));
            }
        }
       return ans;
    }
};