class Solution {

    int ans = Integer.MIN_VALUE ;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i<amount.length ; i++) map.put(i,new ArrayList<>()) ;

        for(int[] i : edges){
            map.get(i[0]).add(i[1]) ;
            map.get(i[1]).add(i[0]) ;
        }

        int[] b = new int[amount.length] ;
        Arrays.fill(b,-1) ;

        bDfs(b,bob,-1,map,0) ;

        aDfs(0,-1,0,0,b,amount,map) ;

        return ans ;
    }

    public void bDfs(int[] b , int node , int fin ,
                     Map<Integer,List<Integer>> map , int time){

        if(b[0] != -1) return ;

        if(node == 0){
            b[0] = time ;
            return ;
        }

        for(int e : map.get(node)){
            if(e == fin) continue ;
            bDfs(b , e , node , map , time + 1) ;
            if(b[0] != -1){
                b[node] = time ;
                return ;
            }
        }
    }

    public void aDfs(int node , int fin , int time , int curr , int[] b , int[] amount , Map<Integer ,List<Integer>> map){

        if(b[node] == -1 || time < b[node]) curr += amount[node] ;
        else if(time == b[node]) curr += amount[node]/2 ;

        boolean leaf = true ;

        for(int e : map.get(node)){
            if(e == fin) continue ;
            leaf = false ;
            aDfs(e , node , time + 1 , curr , b , amount , map) ;
        }

        if(leaf) ans = Math.max(ans , curr) ;
    }
}