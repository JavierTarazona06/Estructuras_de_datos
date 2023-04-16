package Exercises;

import Data.DynamicList;

import java.util.Scanner;

public class SeleccionDesarrolladores {

    public static DynamicList leerDatosaLista(String data){
        DynamicList lista = new DynamicList();
        String current = "";
        for (int e=0; e<=data.length();e++){
            if (e != data.length() && data.charAt(e) != ' ') {
                current += data.charAt(e);
            } else {
                int value = Integer.parseInt(current);
                lista.pushBack(value);
                current = "";
            }
        }
        return  lista;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //int m = Integer.parseInt(input.nextLine());
        int m = input.nextInt();
        input.nextLine();

        DynamicList habilidades = new DynamicList();

        for (int i=0; i<m; i++){
            int value = input.nextInt();
            habilidades.pushBack(value);
        }

        input.nextLine();

        int n = Integer.parseInt(input.nextLine());
        int accFunctWorkers = 0;

        //For each worker
        for (int i=0; i<n; i++){
            String data = input.nextLine();
            DynamicList worker = leerDatosaLista(data);

            int habiCons = 0;

            for (int j=0; j<habilidades.index; j++){
                if (worker.find(habilidades.list[j])){
                    habiCons += 1;
                }
            }

            accFunctWorkers += (habiCons==m) ? 1 : 0;
        }

        System.out.print(accFunctWorkers);
    }
}