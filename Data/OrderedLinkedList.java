package Data;

import java.util.Scanner;

public class OrderedLinkedList extends LinkedList<Integer> {

    public OrderedLinkedList(){
        super();
        System.out.println("Order LinkedList Created");
    }

    public void delete(int key) {
        Node<Integer> ptr = this.head;
        Node<Integer> prev = null;
        while (ptr != null && ptr.key != key) {
            prev = ptr;
            ptr = ptr.next;
        }
        ptr = ptr.next;
        prev.next = ptr;
    }

    public static void main() {
        Scanner input = new Scanner(System.in);

        Node<Integer> n1 = new Node<Integer>(8);
        Node<Integer> n2 = new Node<Integer>(5);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(2);
        Node<Integer> n5 = new Node<Integer>(1);

        OrderedLinkedList theList = new OrderedLinkedList();
        theList.pushFront(n1);
        theList.pushFront(n2);
        theList.pushFront(n3);
        theList.pushFront(n4);
        theList.pushFront(n5);

        theList.print();

        theList.delete(3);

        theList.print();

        // theList.printindexListRecursive(theList.head);

    }
}