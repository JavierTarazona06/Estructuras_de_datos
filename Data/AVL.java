package Data;

import java.util.Scanner;

public class AVL extends BST{

    public AVL(){
        super();
    }

    public NodeT<Integer> rotateRight(NodeT<Integer> node_original){
        if (node_original == null || node_original.left == null){
            return node_original;
        } else {
            NodeT<Integer> new_parent = node_original.left;
            node_original.left = new_parent.right;
            new_parent.right = node_original;
            if (this.root == node_original){
                this.root = new_parent;
            }
            return new_parent;
        }
    }

    public NodeT<Integer> rotateLeft(NodeT<Integer> node_original){
        if (node_original == null || node_original.right == null){
            return node_original;
        } else {
            NodeT<Integer> new_parent = node_original.right;
            node_original.right = new_parent.left;
            new_parent.left = node_original;
            if (this.root == node_original){
                this.root = new_parent;
            }
            return new_parent;
        }
    }

    public NodeT<Integer> rotateDoubleToRight(NodeT<Integer> node_or){
        node_or.left = this.rotateLeft(node_or.left);
        return this.rotateRight(node_or);
    }

    public NodeT<Integer> rotateDoubleToLeft(NodeT<Integer> node_or){
        node_or.right = this.rotateRight(node_or.right);
        return this.rotateLeft(node_or);
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
        int factorBalance = this.factorBalance(ptr);
        if ((factorBalance > 1) && (num > ptr.left.key)){
            ptr = this.rotateDoubleToRight(ptr);
        }
        if ((factorBalance > 1) && (num < ptr.left.key)){
            ptr = this.rotateRight(ptr);
        }
        if ((factorBalance < -1) && (num < ptr.right.key)){
            ptr = this.rotateDoubleToLeft(ptr);
        }
        if ((factorBalance < -1) && (num > ptr.right.key)){
            ptr = this.rotateLeft(ptr);
        }
        return ptr;
    }

    public void insert (int num){
        this.root = this.insert(num,this.root);
    }

    public int factorBalance(NodeT<Integer> ptr){
        return this.height(ptr.left)-this.height(ptr.right);
    }



    public NodeT<Integer> delete(NodeT<Integer> toDelete, NodeT<Integer> ptr) throws Exception {
        if (ptr!=null){
            if (toDelete.key < ptr.key){
                ptr.left = this.delete(toDelete,ptr.left);
            } else if (toDelete.key > ptr.key){
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
                NodeT<Integer> sig = this.next(ptr);
                ptr.key = sig.key;
                ptr.right = this.delete(sig, ptr.right);
            }
            int factorBalance = this.factorBalance(ptr);
            if ((factorBalance > 1) && (toDelete.key > ptr.left.key)){
                ptr = this.rotateDoubleToRight(ptr);
            }
            if ((factorBalance > 1) && (toDelete.key < ptr.left.key)){
                ptr = this.rotateRight(ptr);
            }
            if ((factorBalance < -1) && (toDelete.key < ptr.right.key)){
                ptr = this.rotateDoubleToLeft(ptr);
            }
            if ((factorBalance < -1) && (toDelete.key > ptr.right.key)){
                ptr = this.rotateLeft(ptr);
            }
            return ptr;
        } else {
            return null;
        }
    }

    public void delete(NodeT<Integer> toDelete) throws Exception {
        if (this.isNode(toDelete)){
            this.root = this.delete(toDelete,this.root);
        } else {
            throw new Exception("Node not in tree");
        }
    }

    public static void main(String[] args) throws Exception {
        AVL myTree= new AVL();
        System.out.println(myTree);
        System.out.println("Ingrese números en una línea:");
        Scanner input = new Scanner(System.in);
        //String data = input.nextLine();
        String data = "10 5 15 13 17 19 18 4 3 16 1 2 20 21";
        System.out.println(data);
        myTree.inputLineTOInsert(data);
        System.out.println(myTree.size());
        System.out.println(myTree.levelOrder());
        System.out.println("----");
        myTree.delete(myTree.find(16));
        myTree.delete(myTree.find(17));
        myTree.delete(myTree.find(19));
        myTree.delete(myTree.find(18));
        myTree.delete(myTree.find(20));
        System.out.println(myTree.size());
        System.out.println(myTree.levelOrder());
        System.out.println("----");
        System.out.println(myTree.inOrder());
    }
}
