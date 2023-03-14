package Exercises;
import Data.LinkedList;
import Data.Node;

import java.util.Scanner;

public class Robots {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String data = input.nextLine();
        String current = "";
        int value;

        LinkedList stackCompRight = new LinkedList();
        LinkedList stackCompLeft  = new LinkedList();
        Node ins;

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                ins = new Node(value);
                if (value > 0){
                    stackCompLeft.pushBack(ins);
                } else {
                    stackCompRight.pushBack(ins);
                }
                current = "";
            }
        }

        int rLeft;
        int rRight;
        int match;
        while (!stackCompLeft.isEmpty() && !stackCompRight.isEmpty()){
            rLeft = stackCompLeft.topBack();
            stackCompLeft.popBack();
            rRight = stackCompRight.topFront();
            stackCompRight.popFront();
            match = rLeft + rRight;
            if (match > 0){
                ins = new Node(rLeft);
                stackCompLeft.pushBack(ins);
            } else if (match < 0) {
                ins = new Node(rRight);
                stackCompRight.pushFront(ins);
            }
        }

        if (stackCompLeft.isEmpty() && stackCompRight.isEmpty()){
            System.out.println("No quedaron robots!");
        } else if (stackCompLeft.isEmpty()){
            System.out.println(stackCompRight);
        } else {
            System.out.println(stackCompLeft);
        }

        input.close();
    }
}