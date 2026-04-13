class Solution {
public:
    int minTimeToType(string word) {
        char prev = 'a';
        int ans = 0;
        for(int i = 0; i < word.size(); i++){
            char x = word[i];
            int diff = abs(prev - x);
            ans += min(diff, 26 - diff);
            ans += 1; 
            prev = x;
        }
        return ans;
    }
};