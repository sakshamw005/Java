class Solution {
    static String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"} ;
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>() ;
        if(digits.isEmpty()){
            return ans ;
        }
        print(digits,"",ans) ;
        return ans ;
    }
    public static void print(String s , String ans , List<String> l){
        if(s.length()==0){
            l.add(ans) ;
            return ;
        }
        char ch = s.charAt(0) ;
        String ques = key[ch-'0'] ;
        for(int i = 0 ; i<ques.length() ; i++){
            print(s.substring(1),ans+ques.charAt(i),l) ;
        }
    }
}