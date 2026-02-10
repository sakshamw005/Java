class Solution {
    static List<String> ll = new ArrayList<>();
    public List<String> findWords(char[][] maze, String[] words) {
        ll.clear();
        Trie t = new Trie();
        for (String s : words) {
            t.insert(s);
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (t.root.child.containsKey(maze[i][j])) {
                    t.search(maze, i, j, t.root);
                }
            }
        }
        return ll;
    }

    static class Trie {
        class Node {
            char ch;
            String isterminal;
            HashMap<Character, Node> child;

            Node(char ch) {
                this.ch = ch;
                this.child = new HashMap<>();
            }
        }

        Node root = new Node('*');

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node(ch));
                curr = curr.child.get(ch);
            }
            curr.isterminal = word;
        }

        public void search(char[][] maze, int i, int j, Node node) {

            if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length ||
                !node.child.containsKey(maze[i][j])) {
                return;
            }

            char ch = maze[i][j];
            node = node.child.get(ch);

            if (node.isterminal != null) {
                ll.add(node.isterminal);
                node.isterminal = null; 
            }

            maze[i][j] = '*';

            search(maze, i + 1, j, node);
            search(maze, i - 1, j, node);
            search(maze, i, j + 1, node);
            search(maze, i, j - 1, node);

            maze[i][j] = ch;
        }
    }
}
