package Data;
import java.util.Scanner;

public class BST<T extends Comparable<T>> {
    public NodeT<T> root = null;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size(NodeT<T> ptr){
        if (ptr==null){
            return 0;
        } else {
            return 1 + this.size(ptr.left) + this.size(ptr.right);
        }
    }

    public int size(){
        return this.size(this.root);
    }

    public int height(NodeT<T> ptr){
        if (ptr==null){
            return 0;
        } else {
            int l = height(ptr.left);
            int r = height(ptr.right);
            return l > r ? 1 + l : 1 + r;
        }
    }

    public int height(){
        return height(this.root);
    }

    public int level(T toSearch, NodeT<T> ptr, boolean checked) throws Exception {
        if (ptr==null){
            if (!checked){
                throw new Exception("Node not in tree");
            } else {
                return 0;
            }
        } else {
            if (toSearch.compareTo(ptr.key) == 0){
                return 1;
            } else if (toSearch.compareTo(ptr.key) > 0){
                return 1+this.level(toSearch, ptr.right, checked);
            } else {
                return 1+this.level(toSearch, ptr.left, checked);
            }
        }
    }

    public int level(T toSearch) throws Exception {
        return this.level(toSearch,this.root,false);
    }

    public boolean isNode(NodeT<T> ptr) throws Exception {
        try{
            this.level(ptr.key);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public NodeT<T> find(T toSearch, NodeT<T> ptr) throws Exception {
        if (toSearch.compareTo(ptr.key) == 0){
            return ptr;
        } else if (toSearch.compareTo(ptr.key) > 0) {
            if (ptr.right != null){
                return this.find(toSearch, ptr.right);
            } else {
                throw new Exception("Node not in tree");
            }
        } else {
            if (ptr.left != null){
                return this.find(toSearch, ptr.left);
            } else {
                throw new Exception("Node not in tree");
            }
        }
    }

    public NodeT<T> find(T toSearch) throws Exception {
        return this.find(toSearch,this.root);
    }

    public NodeT<T> prev(NodeT<T> ptr){
        if (ptr.left != null){
            return this.rightDescendant(ptr.left);
        } else {
            try{
                return this.leftAncestor(ptr);
            } catch (Exception NullPointerException){
                return ptr.left;
            }
        }
    }

    public NodeT<T> rightDescendant(NodeT<T> ptr){
        return (ptr.right==null) ? ptr : this.rightDescendant(ptr.right);
    }

    public NodeT<T> leftAncestor(NodeT<T> fixed, NodeT<T> ptr, Stack<NodeT<T>> stack) {
        if (ptr != null){
            if (fixed.key.compareTo(ptr.key) < 0){
                return this.leftAncestor(fixed,ptr.left,stack);
            } else if (fixed.key.compareTo(ptr.key) > 0) {
                stack.push(new Node<NodeT<T>>(ptr));
                return this.leftAncestor(fixed,ptr.right,stack);
            } else {
                return stack.pop();
            }
        } else {
            return null;
        }
    }

    public NodeT<T> leftAncestor(NodeT<T> fixed) throws Exception {
        if (this.isNode(fixed)){
            Stack<NodeT<T>> stack = new Stack<NodeT<T>>();
            return this.leftAncestor(fixed,this.root,stack);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public NodeT<T> next(NodeT<T> ptr) throws Exception {
        if (ptr.right != null){
            return this.leftDescendant(ptr.right);
        } else {
            try{
                return this.rightAncestor(ptr);
            } catch (Exception NullPointerException){
                return ptr.right;
            }
        }
    }

    public NodeT<T> leftDescendant(NodeT<T> ptr){
        return (ptr.left == null) ? ptr : this.leftDescendant(ptr.left);
    }

    public NodeT<T> rightAncestor(NodeT<T> fixed, NodeT<T> ptr, Stack<NodeT<T>> stack) {
        if (ptr != null){
            if (fixed.key.compareTo(ptr.key) < 0){
                stack.push(new Node<NodeT<T>>(ptr));
                return this.rightAncestor(fixed,ptr.left,stack);
            } else if (fixed.key.compareTo(ptr.key) > 0) {
                return this.rightAncestor(fixed,ptr.right,stack);
            } else {
                return stack.pop();
            }
        } else {
            return null;
        }
    }

    public NodeT<T> rightAncestor(NodeT<T> fixed) throws Exception {
        if (this.isNode(fixed)){
            Stack<NodeT<T>> stack = new Stack<NodeT<T>>();
            return this.rightAncestor(fixed,this.root,stack);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public DynamicList rangeSearch(T x, T y) throws Exception {
        DynamicList values = new DynamicList();
        NodeT<T> st = this.find(x);
        while (st != null && ((st.key.compareTo(y) < 0) || (st.key.compareTo(y) == 0))){
            values.pushBack((Integer) st.key);
            st = this.next(st);
        }
        return values;
    }

    public DynamicList rangeSearchInvs(T x, T y) throws Exception {
        DynamicList values = new DynamicList();
        NodeT<T> st = this.find(x);
        while (st != null && ((st.key.compareTo(y) > 0) || (st.key.compareTo(y) == 0))){
            values.pushBack((Integer) st.key);
            st = this.prev(st);
        }
        return values;
    }

    public NodeT<T> parent (NodeT<T> son, NodeT<T> ptr, NodeT<T> poParent){
        if (ptr != null){
            if (son.key.compareTo(ptr.key) < 0){
                return this.parent(son,ptr.left,ptr);
            } else if (son.key.compareTo(ptr.key) > 0){
                return this.parent(son,ptr.right,ptr);
            } else {
                return poParent;
            }
        } else {
            return ptr;
        }
    }

    public NodeT<T> parent (NodeT<T> toSearch) throws Exception {
        if (this.isNode(toSearch)){
            return this.parent(toSearch,this.root,null);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public NodeT<T> max(NodeT<T> ptr){
        if (ptr.right != null){
            return this.max(ptr.right);
        } else {
            return ptr;
        }
    }

    public NodeT<T> max(){
        return this.max(this.root);
    }

    public NodeT<T> min(NodeT<T> ptr){
        if (ptr.left != null){
            return this.min(ptr.left);
        } else {
            return ptr;
        }
    }

    public NodeT<T> min(){
        return this.min(this.root);
    }

    public void lineTOInsert(String data) throws Exception {
        String[] dataSet = data.split(" ");
        for (String s : dataSet) {
            this.insert((T) s);
        }
    }

    public NodeT<T> insert(T num,NodeT<T> ptr) {
        if (ptr==null) {
            ptr = new NodeT<T>(num);
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
        return ptr;
    }

    public void insert (T num){
        this.root = this.insert(num,this.root);
    }

    public NodeT<T> delete(NodeT<T> toDelete, NodeT<T> ptr) throws Exception {
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
            return ptr;
        } else {
            return null;
        }
    }

    public void delete(NodeT<T> toDelete) throws Exception {
        if (this.isNode(toDelete)){
            this.root = this.delete(toDelete,this.root);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public String levelOrder(Queue<NodeT<T>> level, int nlevel) throws Exception {
        if (level.isEmpty()){
            return "";
        } else {
            NodeT<T> cur_node = level.dequeue();

            if (cur_node.left!=null){
                level.enqueue(new Node<NodeT<T>>(cur_node.left));
            }
            if (cur_node.right!=null){
                level.enqueue(new Node<NodeT<T>>(cur_node.right));
            }

            if (nlevel+1 == this.level(cur_node.key)){
                return "\n"+cur_node.key+" "+this.levelOrder(level, nlevel+1);
            } else {
                return cur_node.key+" "+this.levelOrder(level, nlevel);
            }
        }
    }

    public String levelOrder() throws Exception {
        if (this.isEmpty()){
            return "";
        } else {
            Queue<NodeT<T>> level = new Queue<NodeT<T>>();
            level.enqueue(new Node<NodeT<T>>(this.root));
            int nlevel = 1;
            return this.levelOrder(level, nlevel);
        }
    }

    public String inOrder(NodeT<T> ptr){
        if (ptr == null){
            return "";
        } else {
            String result = "";
            result += this.inOrder(ptr.left);
            result += ptr.key + " ";
            result += this.inOrder(ptr.right);
            return result;
        }
    }

    public String inOrder(){
        return this.inOrder(this.root);
    }

    public String inOrderInv(NodeT<T> ptr){
        if (ptr == null){
            return "";
        } else {
            String result = "";
            result += this.inOrderInv(ptr.right);
            result += ptr.key + " ";
            result += this.inOrderInv(ptr.left);
            return result;
        }
    }

    public String inOrderInv(){
        return this.inOrderInv(this.root);
    }

    public String preOrder(NodeT<T> ptr){
        if (ptr == null){
            return "";
        } else {
            String result = "";
            result += ptr.key + " ";
            result += this.preOrder(ptr.left);
            result += this.preOrder(ptr.right);
            return result;
        }
    }

    public String preOrder(){
        return this.preOrder(this.root);
    }

    public String posOrder(NodeT<T> ptr){
        if (ptr == null){
            return "";
        } else {
            String result = "";
            result += this.posOrder(ptr.left);
            result += this.posOrder(ptr.right);
            result += ptr.key + " ";
            return result;
        }
    }

    public String posOrder(){
        return this.posOrder(this.root);
    }

    public int distance(NodeT<T> node, NodeT<T> ptr) throws Exception {
        if (this.isNode(node)){
            if (node.compareTo(ptr) == 0){
                return 1;
            } else {
                if (node.compareTo(ptr) > 0){
                    return 1 + this.distance(node, ptr.right);
                } else {
                    return 1 + this.distance(node, ptr.left);
                }
            }
        } else {
            throw new Exception("There is no node "+node.key);
        }
    }

    public int minDistanceNodes(NodeT<T> node1, NodeT<T> node2, NodeT<T> ptr) throws Exception {
        if (node1.compareTo(ptr) < 0 && node2.compareTo(ptr) < 0){
            return this.minDistanceNodes(node1, node2, ptr.left);
        } else if (node1.compareTo(ptr) > 0 && node2.compareTo(ptr) > 0){
            return this.minDistanceNodes(node1, node2, ptr.right);
        } else {
            return this.distance(node1,ptr) + this.distance(node2,ptr) - 1;
        }
    }

    public int minDistanceNodes(NodeT<T> node1, NodeT<T> node2) throws Exception {
        if (!this.isEmpty()){
            return minDistanceNodes(node1,node2,this.root);
        } else {
            throw new Exception("Tree is empty");
        }
    }
}