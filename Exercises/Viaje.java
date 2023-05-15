package Exercises;
import Data.*;

import java.util.Scanner;
public class Viaje {

    public static void main(String[] args) throws Exception {
        AVL<String> myTree = new AVL<String>();
        myTree.insert("c");
        myTree.insert("a");
        myTree.insert("f");
        myTree.insert("g");
        System.out.println(myTree.levelOrder());
        System.out.println(myTree.preOrder());
        System.out.println(myTree.inOrder());
        System.out.println(myTree.posOrder());
    }
}
