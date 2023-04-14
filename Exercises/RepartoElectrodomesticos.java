package Exercises;

import Data.DynamicList;
import Data.Node;
import Data.Queue;

import java.util.Scanner;

public class RepartoElectrodomesticos {

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
        int repite = Integer.parseInt(input.nextLine());

        for (int i=0;i<repite;i++){

            int n_productos = Integer.parseInt(input.nextLine());

            String data = input.nextLine();
            String current = "";
            String word;

            Node<String> node_inst;
            Queue<String> productos = new Queue<String>();

            for (int e=0; e<data.length()+1; e++){
                if (e != data.length() && data.charAt(e)!=' '){
                    current += data.charAt(e);
                } else {
                    word = current;
                    node_inst = new Node<String>(word);
                    productos.enqueue(node_inst);
                    current = "";
                }
            }

            int n_tiendas = Integer.parseInt(input.nextLine());
            String producto;

            String dataProdTiendas = input.nextLine();
            DynamicList n_prod_Tienda =  leerDatosaLista(dataProdTiendas);

            for (int u=0; u<n_tiendas; u++){
                int n_prod_Tienda_Actual = n_prod_Tienda.list[u];
                String result = "[";
                for (int j=0; j<n_prod_Tienda_Actual; j++){
                    if (productos.isEmpty()){
                        result += "]";
                        j = n_prod_Tienda_Actual;
                    } else {
                        producto = productos.dequeue();
                        if (j==n_prod_Tienda_Actual-1){
                            result += producto+"]";
                        } else {
                            result += producto+" ";
                        }
                    }
                }
                if (i==repite-1 && u==n_tiendas-1){
                    System.out.print(result);
                } else {
                    System.out.println(result);
                }
            }
        }
    }
}
