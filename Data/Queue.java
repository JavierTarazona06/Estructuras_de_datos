package Data;

public class Queue<T> extends LinkedList<T>{

    public Queue(){
        super();
    }

    public void enqueue(Node<T> newNode){
        this.pushBack(newNode);
    }

    public T dequeue(){
        T data = this.topFront();
        this.popFront();
        return data;
    }
}
