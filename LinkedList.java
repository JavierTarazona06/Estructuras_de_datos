import java.util.*;
public class LinkedList {

    // Attr.
    Node head;

    // Constr.
    public LinkedList() {
        System.out.println("Index List Created");
    }

    // Meth.
    public void pushFront(Node newNode) {
        newNode.next = this.head;
        this.head = newNode;
    }

    public void popFront() {
        if (!this.isEmpty()) {
            this.head = this.head.next;
        } else {
            System.out.println("Esta vacía hermano!!");
        }
    }

    public Integer topFront() {
        Integer data = null;
        if (this.isEmpty()) {
            System.out.println("Esta vacía hermano!!");
        } else {
            data = this.head.key;
        }
        return data;
    }

    public void pushBack(Node newNode) {
        Node headRef = this.head;
        while (headRef.next != null) {
            headRef = headRef.next;
        }
        headRef.next = newNode;
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
        StringBuilder list = new StringBuilder();
        Node headRef = head;
        while (headRef != null) {
            list.append(headRef.key).append(" ");
            headRef = headRef.next;
        }
        return list.toString();
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

    public static void main(String[] args) {
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

        input.close();
    }
}