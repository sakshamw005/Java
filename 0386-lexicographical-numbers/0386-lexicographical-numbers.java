class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>() ;
        print(n,0,l) ;
        return l ;
    }
    public static void print(int n , int curr ,List<Integer> l){
        if(curr>n){
            return ;
        }
        if(curr!=0){
            l.add(curr) ;
        }
        int i = 0 ;
        if(curr==0){
            i=1 ;
        }
        for(;i<=9;i++){
            print(n,curr*10+i,l) ;
        }
    }
}