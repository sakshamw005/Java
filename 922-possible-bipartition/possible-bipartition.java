class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 1 ; i<=n ; i++)map.put(i,new ArrayList<>()) ;
        for(int i = 0 ; i<dislikes.length ; i++){
            map.get(dislikes[i][0]).add(dislikes[i][1]) ;
            map.get(dislikes[i][1]).add(dislikes[i][0]) ;
        }
        int[] color = new int[n+1] ;
        Arrays.fill(color,-1) ;
        // System.out.println(map) ;
        for(int i = 1 ; i<=n ; i++){
            if(color[i]==-1){
                if(!bfs(map,color,i)){
                    return false ;
                }
            }
        }
        return true ;
    }
    public boolean bfs(Map<Integer,List<Integer>> map,int[] color,int st){
        color[st] = 0 ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(st) ;
        while(!q.isEmpty()){
            int n = q.poll() ;
            for(int i : map.get(n)){
                if(color[i]==-1){
                    color[i] = 1 - color[n] ;
                    q.add(i) ;
                }
                if(color[i]==color[n]){
                    return false ;
                }
            }
        }
        return true ;
    }
}
class Pair{
    int vtx ;
    int col ;
    Pair(int vtx ,int col){
        this.vtx = vtx ;
        this.col = col ;
    }
}
//odd length cycle non-bipartite