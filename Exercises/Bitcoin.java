package Exercises;
import Data.*;

import java.util.Scanner;

public class Bitcoin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String data = input.nextLine();
        String current = "";
        int value;

        DynamicList precios = new DynamicList();

        for (int i=0; i<data.length()+1; i++){
            if (i != data.length() && data.charAt(i)!=' '){
                current += data.charAt(i);
            } else {
                value = Integer.parseInt(current);
                precios.pushBack(value);
                current = "";
            }
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