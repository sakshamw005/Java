class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] ans = new int[n] ;
        int[] in = new int[n] ;
        Queue<Integer> q = new LinkedList<>() ;
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i<n ; i++)map.put(i,new ArrayList<>()) ;
        for(int i = 0 ; i<prerequisites.length ; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]) ;
            in[prerequisites[i][0]]++ ;
        }
        int idx = 0 ;
        for(int i = 0 ; i<n ; i++){
            if(in[i]==0){
                q.add(i) ;
                ans[idx++] = i; 
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll() ;
            for(int i : map.get(cur)){
                in[i]-- ;
                if(in[i]==0){
                    q.add(i) ;
                    ans[idx++] = i ;
                }
            }
        }
        return idx!=n ? new int[]{} : ans ;
    }
}