class DictionaryTree {
    private class TreeNode {
        private int key;
        private String value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int k, String val) {
            key = k;
            value = val;
            left = right = null;
        }
    }

    private TreeNode root;

    public DictionaryTree() {
        root = null;
    }

    public void insert(String word) {
        int key = hash(word);
    }

    private void insert(int key, String val, TreeNode current) {

    }

    private int hash(String word) {
        int hash = 0;
        int constantModifier = 13;
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);

            // Simple polynomial hashing
            int val = ascii * (int) Math.pow(constantModifier, word.length() - i);

            hash += val;
        }
        return hash;
    }
}