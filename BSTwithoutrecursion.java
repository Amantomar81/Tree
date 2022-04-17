import java.util.Scanner;

public class BSTwithoutrecursion {
    static Node root;
    public static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
        }
    }
    // insertion without recursion

        public static void insertwithout(Node root, Node newnode){
        if (root == null){
            root = newnode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true){
            parent = current;
            if (current.data > newnode.data){
                current = current.left;
                if (current == null){
                    parent.left = newnode;
                    return;
                }
            }
            if (current.data < newnode.data){
                current = current.right;
                if (current.right == null){
                    parent.right = newnode;
                    return;
                }
            }
        }
    }
    //........inorder
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // count method
    public static int count(Node root){
        if (root == null){
            return 0;
        }

        int c = 1+ count(root.left) + count(root.right);
        return c;
    }
    //.........................
    public static Node minrightsubtree(Node root, Node min){
        if (root == null){
            return min;
        }
        return minrightsubtree(root.right,root.left);
    }

    //.................................
    public static Node maxleftsubtree(Node root , Node max){
        if (root == null){
            return max;
        }
        return maxleftsubtree(root.left , root.right);
    }

    //.................check tree is BST or not........

    public static boolean checkBST(Node root){
        if (root == null){
            return false;
        }
        if (root.left != null && root.left.data < root.data){
            return true;
        }
        if (root.right != null && root.right.data > root.data){
            return true;
        }
        if (!checkBST(root.left) || !checkBST(root.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BSTwithoutrecursion obj = new BSTwithoutrecursion();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            obj.insertwithout(obj.root , new Node(sc.nextInt()));
        }
        inorder(root);
        System.out.println(count(root));

       Node max =  maxleftsubtree(root,root.right);
        System.out.println(max.data);
       Node min = minrightsubtree(root,root.left);
        System.out.println(min.data);

        System.out.println(checkBST(root));
    }

}
