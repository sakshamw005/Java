class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length , ans = 0 ;
        Set<Integer> set = new HashSet<>() ;
        for(int i = 1 ; i<=n ; i++){
            if(!set.contains(i)){
                bfs(i,set,isConnected) ;
                ans++ ;
            }
        }
        return ans ;
    }
    public void bfs(int i,Set<Integer> set,int[][] isConnected){
        Queue<Integer> q = new LinkedList<>() ;
        q.add(i) ;
        //set.add(i) ;
        while(!q.isEmpty()){
            //remove
            int p = q.poll() ;
            //Ignore
            if(set.contains(p)){
                continue ;
            }
            //mark visited
            set.add(p) ;
            //self work
            //add neighbors
            for(int j = 0 ; j<isConnected[p-1].length ; j++){
                if(isConnected[p-1][j]==1 && !set.contains(j+1)){
                    //set.add(j) ;
                    q.add(j+1) ;
                }
            }
        }
    }
}