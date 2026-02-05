class Solution {
    static class Node {
        String isTerminal;
        HashMap<Character, Node> child;

        public Node(char ch) {
            child = new HashMap<>();
        }
    }
    private Node root = new Node('*');
    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            curr.child.putIfAbsent(ch, new Node(ch));
            curr = curr.child.get(ch);
        }
        curr.isTerminal = word;
    }
    public String findRoot(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                return word;
            }
            curr = curr.child.get(ch);
            if (curr.isTerminal != null) {
                return curr.isTerminal;
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(findRoot(w)).append(" ");
        }
        return sb.toString().trim();
    }
}