class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0 ; i<n ; i++)map.put(i,new ArrayList<>()) ;
        for(int i = 0 ; i<edges.length ; i++){
            map.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]}) ;
            map.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]}) ;
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.print(i + " -> ");
        //     for (int[] e : map.get(i)) {
        //         System.out.print("(" + e[0] + "," + e[1] + ") ");
        //     }
        //     System.out.println();
        // }
        int[] ans = new int[n] ;
        Arrays.fill(ans,Integer.MAX_VALUE) ;
        ans[0] = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]) ;
        pq.add(new int[]{0,0}) ; //0 time mai 0th node pe h
        while(!pq.isEmpty()){
            int[] curr = pq.poll() ;
            int t = curr[0] , node = curr[1] ;
            if(ans[node]<t)continue ;
            if(disappear[node]<=t)continue ;
            for(int[] i : map.get(node)){
                int tt = i[1] , noode = i[0] , nt = t+tt ;
                if(nt<ans[noode] && nt<disappear[noode]){
                    ans[noode] = nt ;
                    pq.add(new int[]{nt,noode}) ;
                }
            }
        }
        for(int i = 0 ; i<ans.length ; i++)ans[i] = ans[i]==Integer.MAX_VALUE ? -1 : ans[i] ;
        return ans ;
    }
}
