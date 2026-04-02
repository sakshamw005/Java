class Solution {
public:
    int ladderLength(string bw, string ew, vector<string>& wl) {
        set<string> set (wl.begin(),wl.end()) ;
        if(set.count(ew)==0)return 0 ;
        queue<pair<string,int>> q ;
        q.push({bw,1}) ;
        while(!q.empty()){
            auto curr = q.front() ;
            q.pop() ;
            string wo = curr.first ;
            int freq = curr.second ;
            if(wo==ew){
                return freq ;
            }
            for(int i = 0 ; i < wo.size() ; i++){
                char temp = wo[i] ;
                for(char xx = 'a' ; xx<='z' ; xx++){
                    wo[i] = xx ;
                    if(set.count(wo)){
                        q.push({wo,freq+1}) ;
                        set.erase(wo) ;
                    }
                }
                wo[i] = temp ;
            }
        }
        return 0 ;
    }
};