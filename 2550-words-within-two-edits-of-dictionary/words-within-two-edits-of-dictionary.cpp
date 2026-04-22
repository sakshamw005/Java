class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        vector<string> ans ;
        for(int i = 0 ; i<queries.size() ; i++){
            if(check(queries[i],dictionary))ans.push_back(queries[i]);
        }
        return ans ;
    }
    bool check(string str , vector<string>& dictionary){
        for(int i = 0 ; i<dictionary.size() ;i++){
            if(diff(str,dictionary[i])<3){
                return true ;
            }
        }
        return false ;
    }
    int diff(string i , string j){
        int ans = 0 ;
        for(int x = 0 ; x < i.size() ; x++){
            if(i[x]!=j[x])ans++ ;
        }
        return ans ;
    }
};