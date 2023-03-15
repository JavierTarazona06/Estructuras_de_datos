package Data;
public class Node<T> {
        // Att.
        public T key;
        public Node<T> next;
        public Node<T> prev;

        // Const.
        public Node(T data) {
            this.key = data;
            this.next = null;
            this.prev = null;
        }

    // Meth.

    public T getData() {
        return this.key;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void updateKey(T data) {
        this.key = data;
    }
}