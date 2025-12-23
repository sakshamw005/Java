class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        Word[] a = new Word[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = new Word(arr[i], i);
        }
        Arrays.sort(a , (x,y) ->{
            if (x.length != y.length)
                return x.length - y.length;
            return x.index - y.index;
        }) ;
        StringBuilder sb = new StringBuilder();
        for (Word w : a) {
            sb.append(w.word).append(" ");
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.setLength(sb.length() - 1);
        return sb.toString() ;
    }
}
class Word {
    String word;
    int length;
    int index;

    Word(String w, int i) {
        word = w;
        length = w.length();
        index = i;
    }
}