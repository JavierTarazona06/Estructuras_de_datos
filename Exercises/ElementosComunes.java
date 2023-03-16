package Exercises;
import Data.*;

import java.util.Scanner;

public class ElementosComunes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String data = input.nextLine();
        String current = "";
        int value;

        Node<Integer> inst;

        LinkedList<Integer> elements1 = new LinkedList<Integer>();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                inst = new Node<Integer>(value);
                elements1.pushBack(inst);
                current = "";
            }
        }

        data = input.nextLine();
        current = "";

        LinkedList<Integer> elements2 = new LinkedList<Integer>();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                inst = new Node<Integer>(value);
                elements2.pushFront(inst);
                current = "";
            }
        }

        LinkedList<Integer> elementosFuera1 = new LinkedList<Integer>();
        LinkedList<Integer> elementosFuera2 = new LinkedList<Integer>();

        while (!elements1.isEmpty()){
            int a = elements1.topFront();
            int b = elements2.topFront();
            elements1.popFront();
            elements2.popFront();
            if (a!=b){
                inst = new Node<Integer>(a);
                elementosFuera1.pushBack(inst);
                inst = new Node<Integer>(b);
                elementosFuera2.pushFront(inst);
            }
        }

        if (!elementosFuera1.isEmpty()){
            System.out.print(elementosFuera1);
            System.out.println();
            System.out.print(elementosFuera2);
        }

        input.close();
    }
}