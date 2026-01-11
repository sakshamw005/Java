class Solution {
    Map<String,List<Integer>> map = new HashMap<>() ;
    public List<Integer> diffWaysToCompute(String expr) {
        if(map.containsKey(expr)){
            return map.get(expr) ;
        }
        List<Integer> ans = new ArrayList<>() ;
        for(int i = 0 ; i<expr.length() ; i++){
            char ch = expr.charAt(i) ;
            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> l = diffWaysToCompute(expr.substring(0,i)) ;
                List<Integer> r = diffWaysToCompute(expr.substring(i+1)) ;
                for(int a : l){
                    for(int b : r){
                        if(ch=='+')ans.add(a+b) ;
                        else if(ch=='-')ans.add(a-b) ;
                        else ans.add(a*b) ;
                    }
                }
            }
        }
        if(ans.size()==0){
            ans.add(Integer.parseInt(expr)) ;
        }
        map.put(expr,ans) ;
        return ans ;
    }
}