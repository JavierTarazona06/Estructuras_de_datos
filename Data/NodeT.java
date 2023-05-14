package Data;
public class NodeT<T> implements Comparable<NodeT<T>>{
    // Att.
    public T key;
    public NodeT<T> right;
    public NodeT<T> left;

    // Const.
    public NodeT(T data) {
        this.key = data;
        this.right = null;
        this.left = null;
    }

    // Meth.

    public T getData() {
        return this.key;
    }

    public void updateKey(T data) {
        this.key = data;
    }

    @Override
    public String toString(){
        if (this.key==null){
            return "-";
        } else {
            return String.valueOf(this.key);
        }
    }


    @Override
    public int compareTo(NodeT<T> o) {
        if (this.key > o.key){
            
        }
    }
}