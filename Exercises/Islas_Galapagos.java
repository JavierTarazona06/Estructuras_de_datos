package Exercises;
import Data.*;

import java.util.Scanner;

public class Islas_Galapagos {
    public static void main(String[] args) throws Exception {
        AVL<Integer> isla = new AVL<Integer>();
        Scanner input = new Scanner(System.in);

        //String data = input.nextLine();
        String data =  "4 20 10 -1 16 4 0";
        isla.lineTOInsertRep(data);

        System.out.println(isla.levelOrder());
        System.out.println(isla.inOrder());
    }
}
