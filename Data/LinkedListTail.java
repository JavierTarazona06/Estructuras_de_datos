package Data;

public class LinkedListTail<T> extends LinkedList<T>{

    public Node<T> tail;

    public LinkedListTail() {
        super();
    }

    public void pushFront(Node<T> newNode) {
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    public void popFront() {
        if (!this.isEmpty()) {
            if (size()==1){
                this.head = this.head.next;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
        } else {
            throw new ArrayStoreException("Fail popFront. Linked List Vacia");
        }
    }

    public void pushBack(Node<T> newNode) {
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void popBack() {
        if (!isEmpty()) {
            if (this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
        } else {
            throw new ArrayStoreException("Fail popBack. Linked List Vacia");
        }
    }

    public T topBack() {
        T ans = null;
        if (!this.isEmpty()) {
            ans = this.tail.key;
        } else {
            throw new ArrayStoreException("Fail topBack. Linked List Vacia");
        }
        return ans;
    }
}