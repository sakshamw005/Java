class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for (int x : nums) {
            trie.insert(x);
        }
        
        int ans = 0;
        for (int x : nums) {
            ans = Math.max(ans, trie.getMaxXor(x));
        }
        return ans;
    }
}

class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }
    
    void insert(int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }
    
    int getMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opp = 1 - bit;
            
            if (node.child[opp] != null) {
                maxXor |= (1 << i);
                node = node.child[opp];
            } else {
                node = node.child[bit];
            }
        }
        return maxXor;
    }
}

class TrieNode {
    TrieNode[] child = new TrieNode[2];
}