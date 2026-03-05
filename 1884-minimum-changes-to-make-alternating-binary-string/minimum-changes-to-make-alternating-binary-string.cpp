class Solution {
public:
    int minOperations(string s) {
        int a = 0, b = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s[i] ;

            if(c != (i%2==0 ? '0' : '1')) a++;
            if(c != (i%2==0 ? '1' : '0')) b++;
        }
        return min(a,b);
    }
};