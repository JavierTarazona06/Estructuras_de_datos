package Exercises;
import Data.*;

import java.util.Scanner;

public class ElementosComunes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String data = input.nextLine();
        String current = "";
        int value;

        Node inst;

        LinkedList elements1 = new LinkedList();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                inst = new Node(value);
                elements1.pushBack(inst);
                current = "";
            }
        }

        data = input.nextLine();
        current = "";

        LinkedList elements2 = new LinkedList();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                inst = new Node(value);
                elements2.pushFront(inst);
                current = "";
            }
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