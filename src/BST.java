import java.util.ArrayList;
// Diego Villegas
/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        if(isFound(root, val)){
            return true;
        }
        return false;
    }
    // Recursive and helper method for search
    public boolean isFound(BSTNode n, int val){
        // Base case: When we reach the end, return false
        if(n == null){
            return false;
        }
        // Second Base case: If we find the target, return true
        if(val == n.getVal()){
            return true;
        }
        // Recursive step check right child if val is greater than node
        if(val > n.getVal()){
            return isFound(n.getRight(), val);
        }
        // Recursive step check left child
        return isFound(n.getLeft(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    // Traverse through tree left root right
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        inorder(nodes, root);
        return nodes;
    }
    // Recursive and helper method for getInorder
    public void inorder(ArrayList<BSTNode> nodes, BSTNode n){
        // Base Case: Once we reach the end return
        if(n == null){
            return;
        }
        // Go to Left Child
        inorder(nodes, n.getLeft());
        // Add node to arraylist
        nodes.add(n);
        // Go to Right child
        inorder(nodes, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    // Traverse through tree Root Left Right
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        preorder(nodes, root);
        return nodes;
    }
    // Recursive and helper method for getPreorder
    public void preorder(ArrayList<BSTNode> nodes, BSTNode n){
        // Base Case: Once we reach the end return
        if(n == null){
            return;
        }
        // Add node to arraylist
        nodes.add(n);
        // Go to Left Child
        preorder(nodes, n.getLeft());
        // Go to Right child
        preorder(nodes, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    // Traverse through tree Left Right Root
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        postorder(nodes, root);
        return nodes;
    }
    // Recursive and helper method for getPostorder
    public void postorder(ArrayList<BSTNode> nodes, BSTNode n) {
        // Base Case: Once we reach the end return
        if(n == null){
            return;
        }
        // Go to Left Child
        postorder(nodes, n.getLeft());
        // Go to Right child
        postorder(nodes, n.getRight());
        // Add node to arraylist
        nodes.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    // Insert a node into a true if it isn't on the tree
    public void insert(int val) {
        // TODO: Complete insert
        if(!search(val)){
            insertNum(root, val);
        }
    }
    // Recursive and helper method for insert
    public void insertNum(BSTNode node, int val){
        // Base case: Be able to place a left child
        if(node.getLeft() == null && node.getVal() > val){
            node.setLeft(new BSTNode(val));
            return;
        }
        // Base case: Be able to place right child
        if(node.getLeft() == null && node.getVal() < val){
            node.setRight(new BSTNode(val));
            return;
        }
        // Recursive step: move left side because val is less than node value
        if(val < node.getVal()){
            insertNum(node.getLeft(), val);
        }
        else{
            // Recursive step: move right side because val is greater than node value
            insertNum(node.getRight(), val);
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
