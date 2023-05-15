package Exercises;
import Data.*;

import java.util.Scanner;

public class Islas_Galapagos {
    public static void main() throws Exception {
        AVL<Integer> isla = new AVL<Integer>();
        Scanner input = new Scanner(System.in);

        //String data = input.nextLine();
        String[] data =  "4 20 10 -1 16 4 0".split(" ");
        for (String s : data){
            isla.insertRep(Integer.parseInt(s));
        }
    }
}
