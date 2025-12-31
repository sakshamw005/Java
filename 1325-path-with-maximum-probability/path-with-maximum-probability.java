class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,Map<Integer,Double>> map = new HashMap<>() ;
        for(int i = 0 ; i<n ; i++)map.put(i,new HashMap<>()) ;
        for(int i = 0 ; i<edges.length ; i++){
            map.get(edges[i][0]).put(edges[i][1],succProb[i]);
            map.get(edges[i][1]).put(edges[i][0],succProb[i]);
        }
        // System.out.println(map) ;
        Queue<Integer> q = new LinkedList<>() ;
        double[] prob = new double[n] ;
        prob[start] = 1.0 ;
        q.add(start) ;
        while(!q.isEmpty()){
            int x = q.poll() ;
            for(Map.Entry<Integer, Double> e : map.get(x).entrySet()){
                if(e.getValue()*prob[x]>prob[e.getKey()]){
                    prob[e.getKey()] = e.getValue()*prob[x] ;
                    q.add(e.getKey()) ;
                }
            }
        }
        return prob[end] ;
    }
}