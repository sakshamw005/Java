class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<List<Integer>> ll = new ArrayList<>() ;
        List<String> ans = new ArrayList<>() ;
        boolean[] visited = new boolean[4] ;
        permu(ll,arr,new ArrayList<>(),visited) ;
        for(int i = 0 ; i<ll.size() ; i++){
            String curr = "" ;
            for(int j = 0 ; j<ll.get(i).size() ; j++){
                curr+=ll.get(i).get(j) ;
            }
            if(valid(curr)){
                ans.add(curr) ;
            }
        }
        Collections.sort(ans) ;
        String res = "" ;
        if(ans.size()>0){
            String x = ans.get(ans.size()-1) ;
            res = x.substring(0,2)+":"+x.substring(2) ;
        }
        return res ;
    }
    public void permu(List<List<Integer>> ll,int[] arr,List<Integer> curr ,boolean[] visited){
        if(curr.size()==arr.length){
            ll.add(new ArrayList<>(curr)) ;
            return ;
        }
        for(int i = 0 ; i<arr.length ; i++){
            if(!visited[i]){
                curr.add(arr[i]) ;
                visited[i] = true ;
                permu(ll,arr,curr,visited) ;
                curr.remove(curr.size()-1) ;
                visited[i] = false ;
            }
        }
    }
    public boolean valid(String s){
        if(s.charAt(0)>'2')return false ;
        if(s.charAt(0)=='2'){
            if(s.charAt(1)>='4')return false ;
        }
        if(s.charAt(2)>='6')return false ;
        return true ;
    }
}