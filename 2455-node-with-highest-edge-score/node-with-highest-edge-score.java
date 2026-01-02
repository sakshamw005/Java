class Solution {
    public int edgeScore(int[] edges) {
        // Map<Integer,List<Integer>> map = new HashMap<>() ;
        // for(int i = 0 ; i<edges.length ; i++)map.put(i,new ArrayList<>()) ;
        // for(int i = 0 ; i<edges.length ; i++)map.get(i).add(edges[i]) ;
        // System.out.println(map) ;
        long[] in = new long[edges.length] ;
        for(int i = 0 ; i<edges.length ; i++){
            in[edges[i]]+=i ;
        }
        long max = in[0] ;
        for(long i : in)max = Math.max(i,max) ;
        for(int i = 0 ; i<in.length ; i++)if(in[i]==max)return i ;
        return -1 ;
    }
}