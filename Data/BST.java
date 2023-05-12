package Data;
import java.util.Scanner;

public class BST {
    private NodeT<Integer> root = null;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size(NodeT<Integer> ptr){
        if (ptr==null){
            return 0;
        } else {
            return 1 + this.size(ptr.left) + this.size(ptr.right);
        }
    }

    public int size(){
        return this.size(this.root);
    }

    public int height(NodeT<Integer> ptr){
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

    public int level(int toSearch, NodeT<Integer> ptr, boolean checked) throws Exception {
        if (ptr==null){
            if (!checked){
                throw new Exception("Node not in tree");
            } else {
                return 0;
            }
        } else {
            if (toSearch==ptr.key){
                return 1;
            } else if (toSearch > ptr.key){
                return 1+this.level(toSearch, ptr.right, checked);
            } else {
                return 1+this.level(toSearch, ptr.left, checked);
            }
        }
    }

    public int level(int toSearch) throws Exception {
        return this.level(toSearch,this.root,false);
    }

    public boolean isNode(NodeT<Integer> ptr) throws Exception {
        try{
            this.level(ptr.key);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public NodeT<Integer> find(int toSearch, NodeT<Integer> ptr) throws Exception {
        if (toSearch == ptr.key){
            return ptr;
        } else if (toSearch > ptr.key) {
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

    public NodeT<Integer> find(int toSearch) throws Exception {
        return this.find(toSearch,this.root);
    }

    public NodeT<Integer> prev(NodeT<Integer> ptr){
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

    public NodeT<Integer> rightDescendant(NodeT<Integer> ptr){
        return (ptr.right==null) ? ptr : this.rightDescendant(ptr.right);
    }

    public NodeT<Integer> leftAncestor(NodeT<Integer> fixed, NodeT<Integer> ptr, Stack<NodeT<Integer>> stack) {
        if (ptr != null){
            if (fixed.key < ptr.key){
                return this.leftAncestor(fixed,ptr.left,stack);
            } else if (fixed.key > ptr.key) {
                stack.push(new Node<NodeT<Integer>>(ptr));
                return this.leftAncestor(fixed,ptr.right,stack);
            } else {
                return stack.pop();
            }
        } else {
            return null;
        }
    }

    public NodeT<Integer> leftAncestor(NodeT<Integer> fixed) throws Exception {
        if (this.isNode(fixed)){
            Stack<NodeT<Integer>> stack = new Stack<NodeT<Integer>>();
            return this.leftAncestor(fixed,this.root,stack);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public NodeT<Integer> next(NodeT<Integer> ptr) throws Exception {
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

    public NodeT<Integer> leftDescendant(NodeT<Integer> ptr){
        return (ptr.left == null) ? ptr : this.leftDescendant(ptr.left);
    }

    public NodeT<Integer> rightAncestor(NodeT<Integer> fixed, NodeT<Integer> ptr, Stack<NodeT<Integer>> stack) {
        if (ptr != null){
            if (fixed.key < ptr.key){
                stack.push(new Node<NodeT<Integer>>(ptr));
                return this.rightAncestor(fixed,ptr.left,stack);
            } else if (fixed.key > ptr.key) {
                return this.rightAncestor(fixed,ptr.right,stack);
            } else {
                return stack.pop();
            }
        } else {
            return null;
        }
    }

    public NodeT<Integer> rightAncestor(NodeT<Integer> fixed) throws Exception {
        if (this.isNode(fixed)){
            Stack<NodeT<Integer>> stack = new Stack<NodeT<Integer>>();
            return this.rightAncestor(fixed,this.root,stack);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public DynamicList rangeSearch(int x, int y) throws Exception {
        DynamicList values = new DynamicList();
        NodeT<Integer> st = this.find(x);
        while (st != null && st.key <= y){
            values.pushBack(st.key);
            st = this.next(st);
        }
        return values;
    }

    public DynamicList rangeSearchInvs(int x, int y) throws Exception {
        DynamicList values = new DynamicList();
        NodeT<Integer> st = this.find(x);
        while (st != null && st.key >= y){
            values.pushBack(st.key);
            st = this.prev(st);
        }
        return values;
    }

    public NodeT<Integer> parent (NodeT<Integer> son, NodeT<Integer> ptr, NodeT<Integer> poParent){
        if (ptr != null){
            if (son.key < ptr.key){
                return this.parent(son,ptr.left,ptr);
            } else if (son.key > ptr.key){
                return this.parent(son,ptr.right,ptr);
            } else {
                return poParent;
            }
        } else {
            return ptr;
        }
    }

    public NodeT<Integer> parent (NodeT<Integer> toSearch) throws Exception {
        if (this.isNode(toSearch)){
            return this.parent(toSearch,this.root,null);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public void inputLineTOInsert(String data) {
        String[] dataSet = data.split(" ");
        for (String s : dataSet) {
            this.insert(Integer.parseInt(s));
        }
    }

    public NodeT<Integer> insert(int num,NodeT<Integer> ptr) {
        if (ptr==null) {
            ptr = new NodeT<Integer>(num);
        } else {
            if (num < ptr.key) {
                ptr.left = this.insert(num, ptr.left);
            } else {
                if (num > ptr.key) {
                    ptr.right = this.insert(num, ptr.right);
                } else {
                    System.out.println("El elemento " + num + " ya está en el árbol!");
                }
            }
        }
        return ptr;
    }

    public void insert (int num){
        this.root = this.insert(num,this.root);
    }

    public String levelOrder(Queue<NodeT<Integer>> level){
        if (level.isEmpty()){
            return "";
        } else {
            NodeT<Integer> cur_node = level.dequeue();

            if (cur_node.left!=null){
                level.enqueue(new Node<NodeT<Integer>>(cur_node.left));
            }
            if (cur_node.right!=null){
                level.enqueue(new Node<NodeT<Integer>>(cur_node.right));
            }
            return cur_node.key+" "+this.levelOrder(level);
        }
    }

    public String levelOrder(){
        if (this.isEmpty()){
            return "";
        } else {
            Queue<NodeT<Integer>> level = new Queue<NodeT<Integer>>();
            level.enqueue(new Node<NodeT<Integer>>(this.root));
            return this.levelOrder(level);
        }
    }

    public String inOrder(NodeT<Integer> ptr){
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
        return inOrder(this.root);
    }

    public String preOrder(NodeT<Integer> ptr){
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

    public String posOrder(NodeT<Integer> ptr){
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

    public static void main(String[] args) throws Exception {
        BST myTree= new BST();
        System.out.println(myTree);
        System.out.println("Ingrese números en una línea:");
        Scanner input = new Scanner(System.in);
        //String data = input.nextLine();
        String data = "5 7 3 2 6 4 8";
        System.out.println(data);
        myTree.inputLineTOInsert(data);
        System.out.println(myTree.size());
        System.out.println(myTree.levelOrder());
        System.out.println(myTree.inOrder());
        System.out.println(myTree.preOrder());
        System.out.println(myTree.posOrder());

        System.out.println(myTree.parent(myTree.find(5)));
        System.out.println(myTree.parent(myTree.find(3)));
        System.out.println(myTree.parent(myTree.find(7)));
        System.out.println(myTree.parent(myTree.find(2)));
        System.out.println(myTree.parent(myTree.find(4)));
        System.out.println(myTree.parent(myTree.find(6)));
        System.out.println(myTree.parent(myTree.find(8)));

    }
}
