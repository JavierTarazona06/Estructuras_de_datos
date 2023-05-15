package Exercises;
import Data.*;

import java.util.Scanner;
public class Viaje {

    public static void main(String[] args) throws Exception {
        AVL<String> citiesTree = new AVL<String>();
        Scanner input = new Scanner(System.in);

        String data = "Mongui Sachica Tinjaca Combita Chiquiza Sutamarchan Tibasosa Toca Guican Chivata Topaga Soraca Gameza Guayata Raquira Nobsa Tenza Aquitania";
        citiesTree.lineTOInsert(data);

        System.out.println(citiesTree.levelOrder());
        System.out.println(citiesTree.inOrder());

        String[] task = input.nextLine().split(" ");
        NodeT<String> city1 = new NodeT<String>(task[0]);
        NodeT<String> city2 = new NodeT<String>(task[1]);

        System.out.print(citiesTree.minDistanceNodes(city1, city2));

        input.close();
    }
}
