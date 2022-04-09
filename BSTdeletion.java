// write a program to delete the Node at any position in the tree.
import java.util.Scanner;

public class BSTdeletion {
    static Node root;
    //Node class
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    //Insertion method
    public static void insert(Node temproot,int data){
        if (root == null){
            root = new Node(data);
            return ;
        }
        if (temproot.data > data){
            if (temproot.left == null){
                temproot.left = new Node(data);
            }
            else {
                insert(temproot.left , data);
            }
        }
        if (temproot.data < data){
            if (temproot.right == null){
                temproot.right = new Node(data);
            }
            else {
                insert(temproot.right , data);
            }
        }
        return;
    }
    // Inorder method
    public  static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // for min. value in sub tree
    public static int min(Node root){
        if (root.left == null){
            return root.data;
        }
        return min(root.left);
    }

    // deletion of Node
    public static Node deleteNode(Node root, int val){
        if (root == null){
            return null;
        }
        else if (val < root.data){
            root.left = deleteNode(root.left, val);
        }
        else if (val > root.data){
            root.right = deleteNode(root.right, val);
        }
        else {
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return  root.left;
            }
            else if (root.left == null && root.right == null){
                return null;
            }
            else {
                int minimum = min(root);
                root.data = minimum;
                deleteNode(root.right, minimum);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BSTdeletion  obj = new BSTdeletion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Total number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            obj.insert(obj.root , sc.nextInt());
        }
        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println();
        System.out.println("Insert the Deleting Element: ");
        obj.deleteNode(obj.root , sc.nextInt());
        System.out.println(
                "Inorder traversal of the modified tree");
        obj.inorder(root);


    }
}
