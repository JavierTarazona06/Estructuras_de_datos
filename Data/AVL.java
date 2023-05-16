package Data;

public class AVL<T extends Comparable<T>> extends BST {

    public AVL(){
        super();
    }

    public NodeT<T> rotateRight(NodeT<T> node_original){
        if (node_original == null || node_original.left == null){
            return node_original;
        } else {
            NodeT<T> new_parent = node_original.left;
            node_original.left = new_parent.right;
            new_parent.right = node_original;
            if (this.root == node_original){
                this.root = new_parent;
            }
            return new_parent;
        }
    }

    public NodeT<T> rotateLeft(NodeT<T> node_original){
        if (node_original == null || node_original.right == null){
            return node_original;
        } else {
            NodeT<T> new_parent = node_original.right;
            node_original.right = new_parent.left;
            new_parent.left = node_original;
            if (this.root == node_original){
                this.root = new_parent;
            }
            return new_parent;
        }
    }

    public NodeT<T> rotateDoubleToRight(NodeT<T> node_or){
        node_or.left = this.rotateLeft(node_or.left);
        return this.rotateRight(node_or);
    }

    public NodeT<T> rotateDoubleToLeft(NodeT<T> node_or){
        node_or.right = this.rotateRight(node_or.right);
        return this.rotateLeft(node_or);
    }

    public int factorBalance(NodeT<T> ptr){
        return this.height(ptr.left)-this.height(ptr.right);
    }

    public NodeT<T> insert(Comparable num, NodeT ptr) {
        if (ptr==null) {
            ptr = new NodeT<T>((T) num);
        } else {
            if (num.compareTo(ptr.key) < 0) {
                ptr.left = this.insert(num, ptr.left);
            } else {
                if (num.compareTo(ptr.key) > 0) {
                    ptr.right = this.insert(num, ptr.right);
                } else {
                    System.out.println("El elemento " + num + " ya está en el árbol!");
                }
            }
        }
        int factorBalance = this.factorBalance(ptr);
        if ((factorBalance > 1) && (num.compareTo(ptr.left.key) > 0)){
            ptr = this.rotateDoubleToRight(ptr);
        }
        if ((factorBalance > 1) && (num.compareTo(ptr.left.key) < 0)){
            ptr = this.rotateRight(ptr);
        }
        if ((factorBalance < -1) && (num.compareTo(ptr.right.key) < 0)){
            ptr = this.rotateDoubleToLeft(ptr);
        }
        if ((factorBalance < -1) && (num.compareTo(ptr.right.key) > 0)){
            ptr = this.rotateLeft(ptr);
        }
        return ptr;
    }

    public void insert (Comparable num){
        this.root = this.insert(num,this.root);
    }

    public NodeT<T> insertRep(Comparable num, NodeT ptr) throws Exception {
        if (ptr==null) {
            ptr = new NodeT<T>((T) num);
        } else {
            if (num.compareTo(ptr.key) < 0) {
                ptr.left = this.insertRep(num, ptr.left);
            } else {
                if (num.compareTo(ptr.key) >= 0) {
                    ptr.right = this.insertRep(num, ptr.right);
                }
            }
        }
        int factorBalance = this.factorBalance(ptr);
        if ((factorBalance > 1) && (num.compareTo(ptr.left.key) > 0)){
            ptr = this.rotateDoubleToRight(ptr);
        }
        if ((factorBalance > 1) && (num.compareTo(ptr.left.key) < 0)){
            ptr = this.rotateRight(ptr);
        }
        if ((factorBalance < -1) && (num.compareTo(ptr.right.key) < 0)){
            ptr = this.rotateDoubleToLeft(ptr);
        }
        if ((factorBalance < -1) && (num.compareTo(ptr.right.key) > 0)){
            ptr = this.rotateLeft(ptr);
        }
        return ptr;
    }

    public void insertRep(Comparable num) throws Exception {
        this.root = this.insertRep(num,this.root);
    }

    public NodeT<T> delete(NodeT toDelete, NodeT ptr) throws Exception {
        if (ptr!=null){
            if (toDelete.key.compareTo(ptr.key) < 0){
                ptr.left = this.delete(toDelete,ptr.left);
            } else if (toDelete.key.compareTo(ptr.key) > 0){
                ptr.right = this.delete(toDelete,ptr.right);
            } else {
                //Caso de hojas o un hijo
                if (ptr.left == null){
                    return ptr.right;
                }
                if (ptr.right == null){
                    return ptr.left;
                }
                //Caso con los dos hijos
                NodeT<T> sig = this.next(ptr);
                ptr.key = sig.key;
                ptr.right = this.delete(sig, ptr.right);
            }
            int factorBalance = this.factorBalance(ptr);
            if ((factorBalance > 1) && (toDelete.key.compareTo(ptr.left.key) > 0)){
                ptr = this.rotateDoubleToRight(ptr);
            }
            if ((factorBalance > 1) && (toDelete.key.compareTo(ptr.left.key) < 0)){
                ptr = this.rotateRight(ptr);
            }
            if ((factorBalance < -1) && (toDelete.key.compareTo(ptr.right.key) < 0)){
                ptr = this.rotateDoubleToLeft(ptr);
            }
            if ((factorBalance < -1) && (toDelete.key.compareTo(ptr.right.key) > 0)){
                ptr = this.rotateLeft(ptr);
            }
            return ptr;
        } else {
            return null;
        }
    }

    public void delete(NodeT toDelete) throws Exception {
        if (this.isNode(toDelete)){
            this.root = this.delete(toDelete,this.root);
        } else {
            throw new Exception("Node not in tree");
        }
    }
}
