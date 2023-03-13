package Exercises;
import Data.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Bitcoin {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> values = new ArrayList<Integer>();

        values = (ArrayList<Integer>) Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        DynamicList precios = new DynamicList();

        for (int value : values){
            precios.pushBack(value);
        }

        StaticList dias = new StaticList(precios.index);

        for (int i=0; i< precios.index; i++) {
            int diasEspera = 0;
            for (int j=i+1; j< precios.index; j++){
                if (precios.list[j]>precios.list[i]){
                    diasEspera = j-i;
                    j = precios.index;
                }
            }
            dias.pushBack(diasEspera);
        }

        System.out.println(dias);

        input.close();
    }
}