class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true ;
        }
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i<n ; i++) map.put(i,new ArrayList<>()) ;
        for(int[] i : edges){
            int src = i[0] , des = i[1] ;
            map.get(src).add(des) ;
            map.get(des).add(src) ;
        }
        Set<Integer> set = new HashSet<>() ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(source) ;
        while(!q.isEmpty()){
            //remove
            int x = q.poll() ;
            //ignore
            if(set.contains(x)){
                continue ;
            }
            //mark visited
            set.add(x) ;
            //self work
            if(x==destination){
                return true ;
            }
            //add neighbours
            for(int i : map.get(x)){
                if(!set.contains(i)){
                    q.add(i) ;
                }
            }
        }
        return false ;
    }
}