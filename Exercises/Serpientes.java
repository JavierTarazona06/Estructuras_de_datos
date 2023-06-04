package Exercises;
import Data.*;

import java.util.Scanner;

public class Serpientes {
    public static void main(String[] args) throws Exception {
        Heap path = new Heap();

        Scanner input = new Scanner(System.in);

        String[] data = input.nextLine().split(" ");
        for (String s : data){
            path.insert(Integer.parseInt(s));
        }

        String data_n = input.nextLine();
        int calorias_a_consumir = Integer.parseInt(data_n);

        int calorias = path.getSize();

        int level_caloria_final = path.levelNode(calorias-1);

        int cur_position = 1;

        int calorias_consum = 0;

        for (int i=1; i<=level_caloria_final; i++){
            if ((i < level_caloria_final)  || ((i % 2) != 0)) {
                while (cur_position < Math.pow(2,i)) {
                    if (cur_position >= calorias){
                        break;
                    } else {
                        calorias_consum += path.array.list[cur_position-1];
                        System.out.println("a:" + Integer.toString(cur_position-1) + ": " + path.array.list[cur_position-1]);
                        cur_position += 2;
                    }
                }
                if (i % 2 != 0){
                    cur_position -= 1;
                } else {
                    cur_position += 1;
                }
            } else {
                int e = calorias-1;
                while (e > cur_position-1){
                    calorias_consum += path.array.list[e-1];
                    System.out.println("b:" + Integer.toString(e-1) + ": " + path.array.list[e-1]);
                    e -= 2;
                }
            }
        }

        System.out.println("---------");
        System.out.println(calorias_consum);
        System.out.println("---------");
        System.out.println(path.levelOrder());
        System.out.println("---------");
        System.out.println(calorias);
        System.out.println(level_caloria_final);
        System.out.println("---------");

        String result = (calorias_consum >= calorias_a_consumir) ? "Sobrevive" : "Muere";
        System.out.print(result);
    }
}
