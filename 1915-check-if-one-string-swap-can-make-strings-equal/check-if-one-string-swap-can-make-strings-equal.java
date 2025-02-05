class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length())return false ;
        if(s1.equals(s2))return true ;
        List<Integer> l = new ArrayList<>() ;
        for(int i = 0 ; i<s1.length() ; i++){
            if(s1.charAt(i)!=s2.charAt(i))l.add(i) ;
        }
        if(l.size()!=2)return false ;
        int x = l.get(0) ;
        int y = l.get(1) ;
        if(s1.charAt(x)==s2.charAt(y) && s2.charAt(x)==s1.charAt(y))return true ;
        return false ;
    }
}