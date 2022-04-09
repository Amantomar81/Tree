import java.util.Scanner;

//...............Replace with sum of greater value
public class Replace {

    static Node root;
    static int sum = 0;
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            right = left = null;
        }
    }
    //insertion method
    public static Node insert(Node root, Node n1) {
        if (root == null){
            root = n1;
            return root;
        }
        else {
            if( root.data > n1.data){
                if (root.left == null){
                    root.left = n1;
                }
                else {
                    insert(root.left,n1);
                }
            }
            if( root.data<n1.data){
                if (root.right == null){
                    root.right = n1;
                }
                else {
                    insert(root.right,n1);
                }
            }
        }
        return root;
    }
    //inorder
    public static void inorder(Node root)
    {
        if(root== null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //replace
    public static void Sumreplace(Node root){
        if (root == null){
            return;
        }
        Sumreplace(root.right);
        int temp = root.data;
        root.data = sum;
        sum = sum+temp;
        Sumreplace(root.left);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{30,20,25,10,50,60,70,55};
        int j =1;
        Node root = new Node(arr[0]);
        for ( j = 1; j < arr.length; j++) {
            insert(root,new Node(arr[j]));
        }
        System.out.println("inorder Traversal");
        inorder(root);
        Sumreplace(root);
        System.out.println();
        System.out.println("After modification with highest value sum inorder Traversal");
        inorder(root);

    }
}
