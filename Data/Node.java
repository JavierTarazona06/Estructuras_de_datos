package Data;
public class Node {
    // Att.
    public int key;
    public Node next;

    // Const.
    public Node(int data) {
        this.key = data;
        this.next = null;
    }

    // Meth.

    public int getData() {
        return this.key;
    }

    public Node getNext() {
        return this.next;
    }

    public void updateKey(int data) {
        this.key = data;
    }
}