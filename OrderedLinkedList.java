import java.util.Scanner;

public class OrderedLinkedList extends LinkedList {

    public OrderedLinkedList(){
        super();
        System.out.println("Order LinkedList Created");
    }

    public void delete(int key) {
        Node ptr = this.head;
        Node prev = null;
        while (ptr != null && ptr.key != key) {
            prev = ptr;
            ptr = ptr.next;
        }
        ptr = ptr.next;
        prev.next = ptr;
    }

    public static void main() {
        Scanner input = new Scanner(System.in);

        Node n1 = new Node(8);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

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