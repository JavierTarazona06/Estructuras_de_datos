package Data;
import java.util.Scanner;

public class LinkedList<T> {

    // Attr.
    public Node<T> head;

    // Constr.
    public LinkedList() {}

    // Meth.
    public void pushFront(Node<T> newNode) {
        newNode.next = this.head;
        this.head = newNode;
    }

    public void popFront() {
        if (!this.isEmpty()) {
            this.head = this.head.next;
        } else {
            throw new ArrayStoreException("Fail popFront. Linked List Vacia");
        }
    }

    public T topFront() {
        T data = null;
        if (this.isEmpty()) {
            throw new ArrayStoreException("Fail topFront. Linked List Vacia");
        } else {
            data = this.head.key;
        }
        return data;
    }

    public void pushBack(Node<T> newNode) {
        if (this.head==null){
            this.head = newNode;
        } else {
            Node<T> headRef = this.head;
            while (headRef.next != null) {
                headRef = headRef.next;
            }
            headRef.next = newNode;
        }
    }

    public void popBack() {
        if (!this.isEmpty()) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                Node<T> headRef = this.head;
                while (headRef.next.next != null) {
                    headRef = headRef.next;
                }
                headRef.next = null;
            }
        } else {
            throw new ArrayStoreException("Fail popBack. Linked List Vacia");
        }
    }

    public T topBack() {
        T ans = null;
        if (!this.isEmpty()) {
            Node<T> headRef = this.head;
            while (headRef.next != null) {
                headRef = headRef.next;
            }
            ans = headRef.key;
        } else {
            throw new ArrayStoreException("Fail topBack. Linked List Vacia");
        }
        return ans;
    }

    public void print() {
        Node<T> headRef = head;
        while (headRef != null) {
            System.out.print(headRef.key + " ");
            headRef = headRef.next;
        }
        System.out.println("");
    }

    public String toString(){
        if (isEmpty()){
            return "";
        } else {
            StringBuilder list = new StringBuilder();
            Node<T> headRef = this.head;
            while (headRef.next != null) {
                list.append(headRef.key).append(" ");
                headRef = headRef.next;
            }
            list.append(headRef.key);
            return list.toString();
        }
    }

    public void printRecursive(Node<T> headRef) {
        if (headRef!=null){
            System.out.print(headRef.key+" ");
            printRecursive(headRef.next);
        } else {
            System.out.println("");
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean find(int keyFind){
        boolean flag = false;
        return flag;
    }

    public int size(){
        Node<T> headRef = this.head;
        int size = 0;
        if (isEmpty()){
            return size;
        } else {
            while (headRef.next!=null){
                size++;
                headRef = headRef.next;
            }
            return size+1;
        }
    }

    public void reversePrint(){
        throw new Error("Falta programar reverse Print");
    }

    public static void main() {
        Scanner input = new Scanner(System.in);

        Node<Integer> n1 = new Node<Integer>(8);
        Node<Integer> n2 = new Node<Integer>(5);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(2);
        Node<Integer> n5 = new Node<Integer>(1);
        Node<Integer> n6 = new Node<Integer>(1);

        LinkedList<Integer> theList = new LinkedList<Integer>();
        theList.pushFront(n1);
        theList.pushFront(n2);
        theList.pushFront(n3);
        theList.pushFront(n4);
        theList.pushFront(n5);
        theList.pushFront(n6);
        System.out.println(theList.topFront());

        System.out.println(theList);

    }
}