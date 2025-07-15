class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false ;
        }
        boolean vo = false , co = false ;
        for(char x : word.toCharArray()){
            if(Character.isLetter(x)){
                char s = Character.toLowerCase(x);
                if(s=='a'|| s=='e'||s=='i'||s=='o'||s=='u')vo = true ;
                else{
                    co = true ;
                }
            }
            else if (!Character.isDigit(x)) {
                return false;
            }
        }
        return co&&vo ;
    }
}