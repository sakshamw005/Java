class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> l = new ArrayList<>() ;
        print(tiles,l,"") ;
        return new HashSet<>(l).size() ;
    }
    public static void print(String tiles , List<String> l,String var){
        if(!var.isEmpty()){
            l.add(var) ;
        }
        for(int i = 0 ; i<tiles.length() ; i++){
            String temp = tiles.substring(0,i) + tiles.substring(i+1) ;
            print(temp,l,var+tiles.charAt(i)) ;
        }
    }
}