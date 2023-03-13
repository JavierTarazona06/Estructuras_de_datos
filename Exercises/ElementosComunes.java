package Exercises;
import Data.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ElementosComunes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> values1 = new ArrayList<Integer>();
        ArrayList<Integer> values2 = new ArrayList<Integer>();

        values1 = (ArrayList<Integer>) Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        values2= (ArrayList<Integer>) Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Node inst;

        LinkedList elements1 = new LinkedList();
        LinkedList elements2 = new LinkedList();

        for (int value : values1){
            inst = new Node(value);
            elements1.pushBack(inst);
        }
        for (int value : values2){
            inst = new Node(value);
            elements2.pushFront(inst);
        }


        LinkedList elementosFuera1 = new LinkedList();
        LinkedList elementosFuera2 = new LinkedList();

        while (!elements1.isEmpty()){
            int a = elements1.topFront();
            int b = elements2.topFront();
            elements1.popFront();
            elements2.popFront();
            if (a!=b){
                inst = new Node(a);
                elementosFuera1.pushBack(inst);
                inst = new Node(b);
                elementosFuera2.pushFront(inst);
            }
        }

        System.out.println(elementosFuera1);
        System.out.println(elementosFuera2);

        input.close();
    }
}