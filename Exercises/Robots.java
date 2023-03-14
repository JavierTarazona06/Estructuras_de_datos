package Exercises;
import Data.LinkedList;
import Data.Node;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Robots {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> values = new ArrayList<Integer>();

        values = (ArrayList<Integer>) Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        LinkedList stackCompRight = new LinkedList();
        LinkedList stackCompLeft  = new LinkedList();

        Node ins;

        for (Integer value : values) {
            ins = new Node(value);
            if (value > 0){
                stackCompLeft.pushFront(ins);
            } else {
                stackCompRight.pushBack(ins);
            }
        }

        int rLeft;
        int rRight;
        int match;
        while (!stackCompLeft.isEmpty() && !stackCompRight.isEmpty()){
            rLeft = stackCompLeft.topFront();
            stackCompLeft.popFront();
            rRight = stackCompRight.topFront();
            stackCompRight.popFront();
            match = rLeft + rRight;
            if (match > 0){
                ins = new Node(rLeft);
                stackCompLeft.pushFront(ins);
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
            LinkedList stackCompLeftPr = new LinkedList();
            while (!stackCompLeft.isEmpty()){
                int a = stackCompLeft.topBack();
                stackCompLeft.popBack();
                ins = new Node(a);
                stackCompLeftPr.pushBack(ins);
            }
            System.out.println(stackCompLeftPr);
        }

        input.close();
    }
}