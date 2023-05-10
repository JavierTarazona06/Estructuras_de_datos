package Data;

import java.util.Scanner;

class NodeT<T> {
    T data = null;
    NodeT left = null;
    NodeT right = null;
    NodeT parent = null;

    public NodeT() {
        this.data = null;
    }

    public NodeT(T data) {
        this.left = null;
        this.data = data;
        this.right = null;
        this.parent = null;
    }
}

public class binarySearchTree<T> {

    private NodeT root = null;

    public void binarySearchTree() {
        root = null;
    }

    public NodeT<Integer> insert(int num, NodeT<Integer> parent){
        if (parent==null){
            parent = new NodeT<Integer>(num);
        } else {
            if (num<parent.data){
                parent.left = insert(num,parent.left);
                parent.left.parent = parent;
            } else {
                if (num>parent.data){
                    parent.right = insert(num,parent.right);
                    parent.right.parent = parent;
                } else {
                    System.out.println("El elemento "+num+" ya está en el árbol!");
                }
            }
        }
        return parent;
    }

    public void inputLineTOInsert(){
        System.out.println("Ingrese números en una línea");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        String[] dataSet = data.split(" ");
        int[] numbers = new int[dataSet.length];
        for (int i=0; i< dataSet.length; i++){
            numbers[i] = Integer.parseInt(dataSet[i]);
            root = insert(numbers[i],this.root);
        }
    }

    public boolean isEmpty(){
        if (this.root==null){
            return true;
        } else {
            return false;
        }
    }

    private String pathBreadth(Queue<NodeT<Integer>> level){
        String result = "";
        if (!this.isEmpty()){
            if (level.isEmpty()){
                level.enqueue(new Node<NodeT<Integer>>(this.root));
                return result += pathBreadth(level);
            } else {
                NodeT<Integer> cur = level.dequeue();
                result += Integer.toString(cur.data);
                if (cur.left!=null){
                    level.enqueue(new Node<NodeT<Integer>>(cur.left));
                }
                if (cur.right!=null){
                    level.enqueue(new Node<NodeT<Integer>>(cur.right));
                }
                if (!level.isEmpty()){
                    return result += " " + pathBreadth(level);
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public String levelOrder(){
        Queue<NodeT<Integer>> level = new Queue<NodeT<Integer>>();
        return this.pathBreadth(level);
    }

    private void inOrder(NodeT ptr) {
        if (ptr.left != null && ptr.right != null) {
            System.out.print("(");
            inOrder(ptr.left);
            System.out.print(" " + ptr.data + " ");
            inOrder(ptr.right);
            System.out.print(")");
        } else {
            System.out.print(ptr.data);
        }
    }

    private int size(NodeT current){
        if (current==null){
            return 0;
        } else {
            return 1 + size(current.left) + size(current.right);
        }
    }

    public int size(){
        return this.size(this.root);
    }

    public int height(NodeT current){
        if (current==null){
            return 0;
        } else {
            return 1+Math.max(height(current.left),height(current.right));
        }
    }

    public int height(){
        return this.height(this.root);
    }

    private int level(int toSearch, NodeT<Integer> ptr){
        if (ptr==null){
            return 0;
        } else {
            if (toSearch == ptr.data){
                return 1;
            } else if (toSearch > ptr.data) {
                return 1 + this.level(toSearch,ptr.right);
            } else {
                return 1 + this.level(toSearch,ptr.left);
            }
        }
    }

    public int level(int toSearch){
        return level(toSearch,this.root);
    }

    private NodeT<Integer> find(int toSearch, NodeT<Integer> ptr){
        if (toSearch == ptr.data){
            return ptr;
        } else if (toSearch > ptr.data) {
            if (ptr.right!=null){
                return find(toSearch,ptr.right);
            } else {
                return ptr;
            }
        } else {
            if (ptr.left!=null){
                return find(toSearch,ptr.left);
            } else {
                return ptr;
            }
        }
    }

    public NodeT<Integer> find(int toSearch){
        return this.find(toSearch,this.root);
    }

    public NodeT<Integer> next(NodeT<Integer> n){
        if (n.right!=null){
            return leftDescendant(n.right);
        } else {
            try{
                return rightAncestor(n);
            } catch (Exception NullPointerException){
                //return new NodeT<Integer>();
                return n.right;
            }
        }
    }

    public NodeT<Integer> leftDescendant(NodeT<Integer> n){
        if (n.left==null){
            return n;
        } else {
            return leftDescendant(n.left);
        }
    }

    public NodeT<Integer> rightAncestor(NodeT<Integer> n){
        NodeT<Integer> padre = n.parent;
        if (n.data < padre.data){
            return n.parent;
        } else {
            return rightAncestor(n.parent);
        }
    }

    public DynamicList rangeSearch(int x, int y){
        DynamicList values = new DynamicList();
        NodeT<Integer> N = this.find(x);
        while (N!=null && N.data <= y){
            if (N.data >= x){
                values.pushBack(N.data);
            }
            N = this.next(N);
        }
        return values;
    }

    public static void main(String[] args) {
        binarySearchTree<Character> tree = new binarySearchTree<Character>();
        tree.inputLineTOInsert();
        System.out.println(tree.levelOrder());
        System.out.println("Tree size "+tree.size());
        System.out.println("Tree height "+tree.height());
        System.out.println("Tree height 3: "+tree.height(tree.root.left));
        System.out.println("Tree height 2: "+tree.height(tree.root.left.left));
        System.out.println("Tree height 4: "+tree.height(tree.root.left.right));
        System.out.println("Tree level 6: "+tree.level(6));
        System.out.println("Tree level 3: "+tree.level(3));
        System.out.println("Tree level 2: "+tree.level(2));
        System.out.println("Tree level 4: "+tree.level(4));
        System.out.println("Tree level 1: "+tree.level(1));
        NodeT<Integer> cinco = tree.find(1);
        System.out.println("Tree find "+cinco.data+": "+tree.level(cinco.data));
        System.out.println(cinco.parent.data);
        NodeT<Integer> cico = tree.find(5);
        System.out.println("Next de "+cico.data+" es "+tree.next(cico).data);
        System.out.println("Range: "+tree.rangeSearch(5,9));
        tree.inOrder(tree.root);
    }
}