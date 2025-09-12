class Solution {
    public boolean doesAliceWin(String s) {
        if(!Vowel(s)){
            return false ;
        }
        return true ;
    }
    public boolean Vowel(String s){
        for(char x : s.toCharArray()){
            if(x=='a' ||x=='e' ||x=='i' ||x=='o' ||x=='u'){
                return true ;
            }
        }
        return false ;
    }
}