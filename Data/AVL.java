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

    public void rebalance(){

    }

    public static void main(String[] args) throws Exception {
        AVL myTree= new AVL();
        System.out.println(myTree);
        System.out.println("Ingrese números en una línea:");
        Scanner input = new Scanner(System.in);
        //String data = input.nextLine();
        String data = "10 5 15 13";
        System.out.println(data);
        myTree.inputLineTOInsert(data);
        System.out.println(myTree.size());
        System.out.println(myTree.levelOrder());
        System.out.println(myTree.inOrder());
        System.out.println("----");

        myTree.rotateLeft(myTree.find(10));
        System.out.println(myTree.levelOrder());
        System.out.println(myTree.inOrder());
    }
}
