package Data;

public class Stack<T> extends LinkedList<T>{

    public Stack(){
        super();
    }

    public void push(Node<T> newNode){
        this.pushBack(newNode);
    }

    public T pop(){
        T data = this.topBack();
        this.popBack();
        return data;
    }

    public T top(){
        return this.topBack();
    }
}
