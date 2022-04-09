import javax.management.NotificationFilter;
import java.util.Scanner;

//insertion with recursion
//Traversing -> priorder, inorder, postorder
// check tree is BST or not
//Searching

public class BinarySearchTree {
    static Node root;
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            right = left = null;
        }
    }
    //...................................insertion method
    public static void insert(Node temp, int data) {
        if (root == null){
            root = new Node(data);
            return;
        }
        else {
            if(data < temp.data){
                if (temp.left != null){
                    insert(temp.left, data);
                }
                else {
                    temp.left = new Node(data);
                }
            }
            if(data > temp.data){
                if (temp.right != null){
                    insert(temp.right, data);
                }
                else {
                    temp.right = new Node(data);
                }
            }
        }
    }

    //..........preorder traversal
    public static void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //.............inorder traversal
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //............postorder traversal
    public static void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //check tree is binary search tree or not

    public static boolean checkBST(Node root,boolean flag){
        if (root == null){
            return false;
        }
        if (root.left.data< root.data && root.right.data > root.data){
            return true;
        }
        flag = checkBST(root.left,flag);
        flag = checkBST(root.right,flag);
        return flag;
    }

    //search the element ......element persent in the tree or not means True & False.
    public static boolean search(Node root, int val)
    {
        //boolean result;
        if(root == null)
        {
            return false;
        }
        if(root.data == val)
        {
            return true;
        }
        boolean result=false;
        if(root.data>val)
        {
            result = search(root.left, val);
        }
        else
        {
            result = search(root.right,val);
        }
        return result;
    }


    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of nodes: ");
        int x = sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < x; i++) {
            obj.insert(obj.root,sc.nextInt());
        }
        System.out.println("preorder");
        preorder(root);
        System.out.println();
        System.out.println("inorder");
        inorder(root);
        System.out.println();
        System.out.println("postorder");
        postorder(root);
        System.out.println();
       System.out.println(checkBST(root,false));
        System.out.println("Enter the search element");
        System.out.println(search(root, sc.nextInt()));
        
    }

}
