class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]) ;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>() ; 
        PriorityQueue<Pair> pq2 = new PriorityQueue<>(
            (a,b)-> a.tim==b.tim ? Integer.compare(a.rno,b.rno)
                                 : Long.compare(a.tim, b.tim)
        );

        for(int i = 0 ; i<n ; i++) pq1.add(i) ;

        int[] ans = new int[n] ;

        for(int[] i : meetings){
            long st = i[0] , et = i[1] , dur = et - st;      
            while(!pq2.isEmpty() && pq2.peek().tim <= st){
                pq1.add(pq2.poll().rno) ;
            }

            if (!pq1.isEmpty()) {
                int room = pq1.poll();
                ans[room]++;
                pq2.add(new Pair(room, et));   
            } 
            else {
                Pair p = pq2.poll();
                ans[p.rno]++;
                pq2.add(new Pair(p.rno, p.tim + dur));
            }
        }

        int x = 0 ;
        for(int i = 1 ; i<n ; i++){
            if(ans[i] > ans[x]){
                x = i ;
            }
        }
        return x ;
    }

    class Pair{
        int rno ;
        long tim ;
        Pair(int rno,long tim){
            this.rno = rno ;
            this.tim = tim ;
        }
    }
}