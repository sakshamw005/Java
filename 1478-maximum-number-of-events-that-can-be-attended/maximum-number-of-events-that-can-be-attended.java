class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int day = 1 , ans = 0 , i = 0 , n = events.length ;
        PriorityQueue<Integer> p = new PriorityQueue<>() ;
        while(i<n || !p.isEmpty()){
            while(i<n && events[i][0]==day){
                p.offer(events[i][1]) ;
                i++ ;
            }
            while(!p.isEmpty() && p.peek() < day){
                p.poll() ;
            }
            if (!p.isEmpty()) {
                p.poll();
                ans++;
            }

            day++ ;
        }
        return ans ;
    }
}