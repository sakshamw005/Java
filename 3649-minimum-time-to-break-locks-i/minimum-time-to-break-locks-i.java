class Solution {
    int ans;
    int n;
    int k;
    int[] a;
    boolean[] used;
    public int findMinimumTime(List<Integer> strength, int k) {
        this.n = strength.size();
        this.k = k;
        this.a = strength.stream().mapToInt(i -> i).toArray();;
        this.used = new boolean[n];
        this.ans = Integer.MAX_VALUE;

        dfs(0, 1, 0);
        return ans;
    }
    public void dfs(int cnt , int x , int time){
        if(time>=ans)return  ;
        if(cnt==n){
            ans = Math.min(ans,time) ;
            return ;
        }
        for(int i = 0 ; i<n ; i++){
            if(!used[i]){
                used[i] = true ;
                int need = (a[i] + x - 1) / x;   
                dfs(cnt + 1, x + k, time + need);
                used[i] = false;
            }
        }
    }
}