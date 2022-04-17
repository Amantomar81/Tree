public class BinaryNode1<T> {
    T data;
    BinaryNode1<T> left;
    BinaryNode1<T> right;
    BinaryNode1<T> Lright;
    BinaryNode1<T> Rleft;
    public BinaryNode1(T data){
        this.data = data;

    }
}
class Test1 {
    public static void main(String[] args) {
        BinaryNode1<Integer> root = new BinaryNode1<>(15);
        BinaryNode1<Integer> Rleft = new BinaryNode1<>(16);
        BinaryNode1<Integer> R1right = new BinaryNode1<>(18);
        BinaryNode1<Integer> Rright = new BinaryNode1<>(20);
        BinaryNode1<Integer> R1left = new BinaryNode1<>(60);
        root.left = Rleft;
        root.Lright = R1right;
        root.right = Rright;
        root.Rleft = R1left;
        Print(root);
    }
    public static void Print(BinaryNode1<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        Print(root.left);
        Print(root.right);
        Print(root.Lright);
        Print(root.Rleft);
    }

}
