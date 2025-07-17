class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] n = new int[difficulty.length][2] ;
        for(int i = 0 ; i<profit.length ; i++){
            n[i][0] = difficulty[i] ;
            n[i][1] = profit[i] ;
        }
        Arrays.sort(n, (a, b) -> a[0] - b[0]);
        int ans = 0 ;
        for (int i = 0; i < worker.length; i++) {
            int best = 0;
            for (int j = 0; j <n.length; j++) {
                if (worker[i] >= n[j][0]) {
                    best = Math.max(best, n[j][1]);
                } else {
                    break;
                }
            }
            ans += best;
        }
        return ans ;
    }
}