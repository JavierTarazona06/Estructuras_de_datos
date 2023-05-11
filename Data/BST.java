package Data;
import java.util.Scanner;

public class BST<T> {
    private NodeT<T> root = null;

    public BST() {
        this.root = null;
    }

    public void insert (int num){
        this.insert(num,this.root);
    }

    public NodeT<Integer> insert(int num,NodeT<T> ptr) {
        if (ptr==null) {
            ptr = new NodeT<Integer>(num);
        } else {
            if (num < ptr.key) {
                ptr.left = insert(num, ptr.left);
            } else {
                if (num > ptr.key) {
                    ptr.right = insert(num, ptr.right);
                } else {
                    System.out.println("El elemento " + num + " ya está en el árbol!");
                }
            }
        }
        return ptr;
    }

    /*
    System.out.println("Ingrese números en una línea");
    Scanner input = new Scanner(System.in);
     String data = input.nextLine();
     */
    public void inputLineTOInsert(String data) {
        String[] dataSet = data.split(" ");
        for (String s : dataSet) {
            root = insert(Integer.parseInt(s), this.root);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public String levelOrder(){
        Queue<NodeT<T>> level = new Queue<NodeT<T>>();
        level.enqueue(new Node<NodeT<T>>(this.root));
    }

    public static void main(String[] args) {
        BST<Integer> myTree= new BST<Integer>();
        System.out.println(myTree);
        System.out.println("Ingrese números en una línea:");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        myTree.inputLineTOInsert(data);
        System.out.println(myTree.root.key);
        System.out.println(myTree.root.right.key);
        System.out.println(myTree.root.left.key);
    }
}
