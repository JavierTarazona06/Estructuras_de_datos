package Exercises;
import Data.*;

import java.util.Scanner;

public class OrdenExposiciones {

    static LinkedList<String> ordenar(int pasos, LinkedListTail<String> names){
        Node<String> inst;
        LinkedList<String> orden = new LinkedList<String>();
        for (int i=0; i<pasos; i++){
            String a = names.topFront();
            names.popFront();
            String b = names.topBack();
            names.popBack();
            inst = new Node<String>(a);
            orden.pushBack(inst);
            inst = new Node<String>(b);
            orden.pushBack(inst);
        }
        return orden;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String data = input.nextLine();
        String current = "";
        String word;

        Node<String> inst;
        LinkedListTail<String> names = new LinkedListTail<String>();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                word = current;
                inst = new Node<String>(word);
                names.pushBack(inst);
                current = "";
            }
        }

        int pasos;
        int tamano = names.size();

        LinkedList<String> orden = new LinkedList<String>();

        if (tamano%2==0){
            pasos = tamano/2;
            orden = ordenar(pasos,names);
        } else {
            pasos = (tamano+1)/2;
            orden = ordenar(pasos-1,names);
            String c = names.topFront();
            names.popFront();
            inst = new Node<String>(c);
            orden.pushBack(inst);
        }

        System.out.print(orden);
        input.close();
    }
}