class Solution {
    public String sortVowels(String s) {
        List<Character> ll = new ArrayList<>() ;
        for(char x : s.toCharArray()){
            if(isVowel(x)){
                ll.add(x) ;
            }
        }
        Collections.sort(ll) ;
        int i = 0 ;
        StringBuilder ans = new StringBuilder() ;
        for(int m = 0 ; m<s.length() ; m++){
            char x = s.charAt(m) ;
            if(isVowel(x)){
                ans.append(ll.get(i)) ;
                i++ ;
            }
            else{
                ans.append(x) ;
            }
        }
        return ans.toString() ;

    }
    public boolean isVowel(char s){
        return s=='a' || s=='e' || s=='i' || s=='o' || s=='u' || s=='A' 
                      || s=='E' || s=='U' || s=='I' || s=='O' ; 
    }
}