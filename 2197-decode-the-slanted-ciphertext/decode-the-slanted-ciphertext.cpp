class Solution {
public:
    string decodeCiphertext(string str , int rows) {
        int cols = str.size() / rows ;
        vector<vector<char>> arr (rows , vector<char> (cols , ' ')) ;
        for(int i = 0 ; i<str.size() ; i++){
            arr[i/cols][i%cols] = str[i] ;
        }
        string ans = "" ;
        for(int c = 0; c < cols; c++){
            int r = 0, j = c;
            while(r < rows && j < cols){
                ans += arr[r][j];
                r++;
                j++;
            }
        }
        return trim(ans);
    }
    string trim(const string &s) {
        int end = s.size() - 1;
        while (end >= 0 && isspace(s[end])) end--;
        return s.substr(0, end + 1);
    }
};