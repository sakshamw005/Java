class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        sort(courses.begin(), courses.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] < b[1];
        });
        for(int i = 0 ; i<courses.size() ; i++){
            cout << courses[i][0] << " " << courses[i][1] << '\n' ;
        }
        priority_queue<int> pq ;
        int cur = 0 ;
        for(int i = 0 ; i<courses.size() ; i++){
            cur += courses[i][0] ;
            pq.push(courses[i][0]) ;
            if(cur > courses[i][1]){
                cur -= pq.top() ;
                pq.pop() ;
            }
        }
        return pq.size() ;
    }
};