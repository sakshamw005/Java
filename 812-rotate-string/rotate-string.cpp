class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.size()!=goal.size())return false;
        string hehe = goal + goal ;
        return hehe.contains(s) ;
    }
};