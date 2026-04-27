class Solution {
public:
    string getHint(string s, string g) {
        int x = 0 , y = 0 ;
        vector<int> freq(10,0);
        for(int i = 0 ; i<g.size() ; i++)freq[g[i]-'0']++ ;
        for(int i = 0 ; i<s.size() ; i++){
            if(s[i]==g[i]){
                x++ ;
                freq[s[i]-'0']-- ;
            }
        } 
        for(int i = 0 ; i<s.size() ; i++){
            if(s[i]!=g[i] && freq[s[i]-'0']!=0){
                y++ ;
                freq[s[i]-'0']-- ;
            }
        }
        return to_string(x)+"A"+to_string(y)+"B" ;
    }
};