//-----------------------------------------
// NAME: Manuel Espinoza 
// STUDENT NUMBER: 7946366
// COURSE: COMP 2140, SECTION: A02
// INSTRUCTOR: Cuneyt G. Akcora
// ASSIGNMENT: 4
// 
// REMARKS: This program implements a dictionary
//          by using a Binary Search Tree (BST).
//
//-----------------------------------------

import java.util.*;
import java.io.*;

class Dictionary {
    // TreeNode class
    private class TreeNode {
        private String value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String val) {
            value = val;
            left = right = null;
        }
    }
    // End of TreeNode class

    private TreeNode root;

    public Dictionary(String filename) {
        root = null;
        try {
            Scanner scanner = new Scanner(new File(filename));

            // Store every word in the dictionary in lower case
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
        // if tree is empty, insert as root
        if (root == null) {
            root = new TreeNode(word);
        }
        // otherwise, call the private recursive method
        else {
            insert(word, root);
        }
    }

    // ------------------------------------------------------
    // insert
    //
    // PURPOSE: Recursively traverse the tree to find where to
    // insert the given String
    //
    // INPUT PARAMETERS:
    // - the String to insert
    // - the (potential) parent node
    //
    // ------------------------------------------------------
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

    // ------------------------------------------------------
    // search
    //
    // PURPOSE: verifies if a word exists in the dictionary
    //
    // INPUT PARAMETERS:
    // - the word to search
    //
    // OUTPUT PARAMETERS:
    // - Returns true if the word exists in the dictionary, false otherwise
    // ------------------------------------------------------
    public boolean search(String word) {
        word = word.toLowerCase();
        boolean found = false;
        TreeNode current = root;

        // iteratively traverse the tree until the word is found
        // or until we access a leaf's null child
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