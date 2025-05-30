class Solution {
    public List<List<String>> partition(String s) {
        List<String> l = new ArrayList<>() ;
        List<List<String>> ans = new ArrayList<>() ;
        partitioning(s,"",l,ans);
        return (ans) ;
    }
        public static void partitioning(String ques , String ans,List<String> l , List<List<String>> answer){
        if(ques.isEmpty()){
            answer.add(new ArrayList<>(l)) ;
            return ;
        }
        for(int cut = 1 ; cut<=ques.length() ; cut++){
            String s = ques.substring(0,cut) ;
            if(isPalindrome(s)) {
                l.add(s) ;
                partitioning(ques.substring(cut), ans + s , l , answer);
                l.remove(l.size()-1) ;
            }
        }
    }
    public static boolean isPalindrome(String s) {
        int f = 0, l = s.length() - 1;
        while(f < l) {
            if(s.charAt(f) != s.charAt(l))
                return false;

            f++;
            l--;
        }
        return true;
    }
}