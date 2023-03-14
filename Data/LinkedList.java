package Data;

import java.util.*;
public class LinkedList {

    // Attr.
    public Node head;

    // Constr.
    public LinkedList() {}

    // Meth.
    public void pushFront(Node newNode) {
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

    public Integer topFront() {
        Integer data = null;
        if (this.isEmpty()) {
            throw new ArrayStoreException("Fail topFront. Linked List Vacia");
        } else {
            data = this.head.key;
        }
        return data;
    }

    public void pushBack(Node newNode) {
        if (this.head==null){
            this.head = newNode;
        } else {
            Node headRef = this.head;
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
                Node headRef = this.head;
                while (headRef.next.next != null) {
                    headRef = headRef.next;
                }
                headRef.next = null;
            }
        } else {
            System.out.println("Esta vacía hermano!!");
        }
    }

    public Integer topBack() {
        Integer ans = null;
        if (!this.isEmpty()) {
            Node headRef = this.head;
            while (headRef.next != null) {
                headRef = headRef.next;
            }
            ans = headRef.key;
        } else {
            System.out.println("Esta vacía hermano!!");
        }
        return ans;
    }

    public void print() {
        Node headRef = head;
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
            Node headRef = this.head;
            while (headRef.next != null) {
                list.append(headRef.key).append(" ");
                headRef = headRef.next;
            }
            list.append(headRef.key);
            return list.toString();
        }
    }

    public void printRecursive(Node headRef) {
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
        Node headRef = this.head;
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node headRef = this.head;
        while (headRef != null) {
            list.add(headRef.key);
            headRef = headRef.next;
        }
        Collections.reverse(list);
        for (int i : list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main() {
        Scanner input = new Scanner(System.in);

        Node n1 = new Node(8);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        Node n6 = new Node(1);

        LinkedList theList = new LinkedList();
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