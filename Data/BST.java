package Data;
import java.util.Scanner;

public class BST<T> {

    static class Node<T> {
        public T key;
        public Node<Integer> right;
        public Node<Integer> left;

        // Const.
        public Node(T data) {
            super();
            this.key = data;
            this.right = null;
            this.left = null;
        }

        @Override
        public String toString(){
            return String.valueOf(this.key);
        }
    }

    private Node<Integer> root = null;

    public BST() {
        this.root = null;
    }

    public void insert (int num){
        this.insert(num, (Node<Integer>) this.root);
    }

    public Node<Integer> insert(int num,Node<Integer> ptr) {
        if (ptr==null) {
            ptr = new Node<Integer>(num);
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

    private String pathBreadth(Queue<BST.Node<T>> level) {
        String result = "";
        boolean flag = true;
        if (!this.isEmpty()) {
            if (level.isEmpty()) {
                level.enqueue(new Data.Node<Node<T>>((Node<T>) this.root));
                return result += pathBreadth(level);
            } else {
                Node<T> cur = level.dequeue();
                if (cur == null) {
                    result += "-";
                    flag = false;
                } else {
                    result += cur.toString();
                }
                if (flag) {
                    if (cur.left != null) {
                        level.enqueue(new Data.Node<Node<T>>((Node<T>) cur.left));
                    } else {
                        level.enqueue(new Data.Node<Node<T>>(new Node<T>(null)));
                    }
                    if (cur.right != null) {
                        level.enqueue(new Data.Node<Node<T>>((Node<T>) cur.right));
                    } else {
                        level.enqueue(new Data.Node<Node<T>>(new Node<T>(null)));
                    }
                }
                if (!level.isEmpty()) {
                    return result += " " + pathBreadth(level);
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public String levelOrder() {
        Queue<BST.Node<T>> level = new Queue<BST.Node<T>>();
        return this.pathBreadth(level);
    }

    public static void main(String[] args) {
        BST<Integer> myTree= new BST<Integer>();
        System.out.println(myTree);
        System.out.println("Ingrese números en una línea:");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        myTree.inputLineTOInsert(data);
        System.out.println(myTree.levelOrder());
    }
}
