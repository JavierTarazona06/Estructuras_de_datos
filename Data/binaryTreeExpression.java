package Data;
import java.util.*;

public class binaryTreeExpression<T> {

    class NodeGeneric<T> {
        T data = null;
        NodeGeneric left = null;
        NodeGeneric right = null;

        public NodeGeneric() {
            this.data = null;
        }

        public NodeGeneric(T data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    private NodeGeneric root = null;

    public void binaryTreeExpression() {
        root = null;
    }

    public void createTree() {
        System.out.println();
        System.out.println("Ingrese una expresión prefijo aritmética");
        System.out.println();
        root = inputData();
    }

    public NodeGeneric inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese operando y operador");
        char ch = input.nextLine().charAt(0);
        NodeGeneric act = new NodeGeneric(ch);
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            act.left = inputData();
            act.right = inputData();
        }
        // input.close();
        return act;
    }

    public void infix() {
        System.out.println("Infix:");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(NodeGeneric ptr) {
        if (ptr.left != null && ptr.right != null) {
            System.out.print("(");
            inOrder(ptr.left);
            System.out.print(" " + ptr.data + " ");
            inOrder(ptr.right);
            System.out.print(")");
        } else {
            System.out.print(ptr.data);
        }
    }

    public static void main(String[] args) {
        binaryTreeExpression<Character> tree = new binaryTreeExpression<Character>();
        tree.createTree();
        tree.infix();
    }
}