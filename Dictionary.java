//-----------------------------------------
// NAME: Manuel Espinoza 
// STUDENT NUMBER: 7946366
// COURSE: COMP 2140, SECTION: A02
// INSTRUCTOR: Cuneyt Akcora
// ASSIGNMENT: assignment #, QUESTION: question #
// 
// REMARKS: What is the purpose of this code?
//
//-----------------------------------------

import java.util.*;
import java.io.*;

class Dictionary {
    private class TreeNode {
        private String value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String val) {
            value = val;
            left = right = null;
        }
    }

    private TreeNode root;

    public Dictionary() {
        root = null;
    }

    public Dictionary(String filename) {
        this();
        try {
            Scanner scanner = new Scanner(new File(filename));

            // Save every word in the dictionary
            while (scanner.hasNext()) {
                String toInsert = scanner.nextLine();
                insert(toInsert.toLowerCase());
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String word) {
        word = word.toLowerCase();
        if (root != null) {
            insert(word, root);
        } else {
            root = new TreeNode(word);
        }
    }

    private void insert(String val, TreeNode current) {
        if (val.compareTo(current.value) < 0) {
            if (current.left != null) {
                insert(val, current.left);
            } else {
                current.left = new TreeNode(val);
            }
        } else if (val.compareTo(current.value) > 0) {
            if (current.right != null) {
                insert(val, current.right);
            } else {
                current.right = new TreeNode(val);
            }
        }
    }

    public boolean search(String word) {
        word = word.toLowerCase();
        boolean found = false;
        TreeNode current = root;

        while (current != null && !found) {
            if (word.compareTo(current.value) < 0) {
                current = current.left;
            } else if (word.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                found = current.value.equals(word);
                current = null;
            }
        }

        return found;
    }
}