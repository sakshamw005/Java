class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> one = new HashSet<>() ;
        Map<String,String> two = new HashMap<>() ;
        Map<String,String> three = new HashMap<>() ;

        for(String x : wordlist){
            one.add(x) ;

            String l = x.toLowerCase() ;
            two.putIfAbsent(l,x) ;

            String n = convert(l) ;
            three.putIfAbsent(n,x) ;
        }

        String[] ans = new String[queries.length] ;
        for(int i = 0 ; i<queries.length ; i++){
            String temp = queries[i] ;
            if(one.contains(temp)){
                ans[i] = temp ;
            }
            else if(two.containsKey(temp.toLowerCase())){
                ans[i] = two.get(temp.toLowerCase()) ;
            }
            else{
                if(three.containsKey(convert(temp.toLowerCase()))){
                    ans[i] = three.get(convert(temp.toLowerCase())) ;
                }
                else{
                    ans[i] = "" ;
                }
            }
        }
        return ans ;
    }
    public String convert(String s){
        StringBuilder ans = new StringBuilder() ;
        for(char x : s.toCharArray()){
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u'){
                ans.append("*") ;
            }
            else{
                ans.append(x) ;
            }
        }
        return ans.toString() ;
    }
}