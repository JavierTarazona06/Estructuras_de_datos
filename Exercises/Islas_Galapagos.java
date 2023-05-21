package Exercises;
import Data.*;

import java.util.Scanner;

public class Islas_Galapagos {
    public static void main() throws Exception {
        Heap isla = new Heap();
        Scanner input = new Scanner(System.in);

        String[] data =  input.nextLine().split(" ");
        for (String s : data){
            isla.insert(Integer.parseInt(s));
        }

        int times = Integer.parseInt(input.nextLine());

        String[] preOrder = isla.preOrder().split(" ");
        int sumPreOrder = 0;
        String[] inOrder = isla.inOrder().split(" ");
        int sumInOrder = 0;
        String[] posOrder = isla.posOrder().split(" ");
        int sumPosOrder = 0;
        for (int i = 0; i < times; i++){
            sumPreOrder += Integer.parseInt(preOrder[i]);
            sumInOrder += Integer.parseInt(inOrder[i]);
            sumPosOrder += Integer.parseInt(posOrder[i]);
        }

        if (sumPosOrder > sumPreOrder && sumPosOrder > sumInOrder){
            System.out.print("Postorder " + sumPosOrder);
        } else if (sumInOrder > sumPreOrder) {
            System.out.print("Inorder " + sumInOrder);
        } else {
            System.out.print("Preorder " + sumPreOrder);
        }

        input.close();
    }
}
