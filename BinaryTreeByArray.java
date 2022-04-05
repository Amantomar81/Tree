import java.util.Scanner;

/*By using the array perform these operations in the binary tree
-> insertion
-> traversal
-> searching
-> deletion
*/
public class BinaryTreeByArray extends Thread{
    int arr[];
    int lastusedIndex;  //traverse at last index

    public BinaryTreeByArray(int size) {
        arr = new int[size+1];  //size+1 because not starting at zero
        lastusedIndex = 0;
    }

//  -> insertion method
    public void insert(int value){
        if (lastusedIndex > arr.length-1){
            return;
        }
        arr[lastusedIndex+1] = value;
        lastusedIndex++;
    }
// -> preorder traversal
    public void preorder(int index) {
        if (index > lastusedIndex){
            return;
        }
        System.out.print(arr[index]+" ");
        preorder(2 * index);
        preorder((2* index) + 1);

    }
// -> postorder traversal
    public void postorder(int index){
        if (index>lastusedIndex){
            return;
        }
        postorder(index*2);
        postorder(index*2+1);
        System.out.print(arr[index]+" ");
    }
// -> inorder traversal
    public void inorder(int index){
        if (index>lastusedIndex){
            return;
        }
        inorder(index*2);
        System.out.print(arr[index]+" ");
        inorder(index*2+1);
    }

    public void levelordertraversal(){
        for (int i = 1; i <= lastusedIndex; i++) {
            System.out.print(arr[i]+" ");

        }
    }
// -> searching
    public int search(int value){

        for (int i = 1; i <= lastusedIndex; i++) {
            if (arr[i] == value){
                System.out.println(value+ " is available in the tree");
                return i;
            }
        }
        System.out.println(value+ "is not available in the tree");
        return -1;
    }

// -> deletion
    public void deletion(int value){
        int res = search(value);
        if (res == -1){
            return;
        }
        System.out.println(value+ " is deleted");
        arr[res] = arr[lastusedIndex];
        lastusedIndex--;
    }
    //main method
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Array: ");
        int x = sc.nextInt();
        BinaryTreeByArray obj = new BinaryTreeByArray(x);
        System.out.println("Enter the elements: ");
        for (int i = 0; i < x; i++) {
            obj.insert(sc.nextInt());
        }

        System.out.println("levelorder traversal: ");
        obj.levelordertraversal();

        System.out.println();
        System.out.println("Enter the deleting element: ");
        obj.deletion(sc.nextInt());
        System.out.println();

        Thread.sleep(1500);
        System.out.println("preorder Traversal: ");
        obj.preorder(1);
        System.out.println();
        Thread.sleep(3500);
        System.out.println("postorder traversal: ");
        obj.postorder(1);
        Thread.sleep(5000);
        System.out.println();
        System.out.println("inorder traversal: ");
        obj.inorder(1);
    }
}
