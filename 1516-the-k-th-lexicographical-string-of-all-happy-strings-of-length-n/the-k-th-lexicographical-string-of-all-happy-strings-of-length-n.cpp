class Solution {
public:
    vector<string> res;
    vector<char> arr = {'a','b','c'};
    string getHappyString(int n, int k) {
        solve(n,"");
        if(k > res.size()) return "";
        return res[k-1];
    }
    void solve(int n, string ans){
        if(ans.size() == n){
            res.push_back(ans);
            return;
        }
        for(int i=0;i<3;i++){
            if(ans.empty() || ans.back() != arr[i]){
                ans.push_back(arr[i]);
                solve(n,ans);
                ans.pop_back();
                
            }
        }
    }
};