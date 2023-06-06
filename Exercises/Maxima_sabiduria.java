package Exercises;

import Data.Heap;

import java.util.Scanner;

public class Maxima_sabiduria {
    public static int sum_levelOrder(Heap tree) throws Exception {
        if (tree.array.empty()){
            throw new Exception("Empty Heap");
        } else {
            int l = 1;
            String result = "";
            int cur_sum = 0;
            int max_sum = 0;
            int level_max=0;
            int nivel_mas_alto = (int) (Math.log10(tree.getSize())/Math.log10(2))+1;
            System.out.println(nivel_mas_alto);
            for (int i = 0; i<tree.getSize(); i++){
                int cur_element = tree.array.list[i];
                int cur_level = tree.levelNode(i);
                System.out.println(i + " : " + cur_element + " : " + l);
                System.out.println("------------");
                if ((l+1) == cur_level){
                    if (cur_sum > max_sum){
                        max_sum = cur_sum;
                        level_max = cur_level;
                    }
                    cur_sum = cur_element;
                    l += 1;
                } else if ((l==nivel_mas_alto) && (i==tree.getSize()-1)) {
                    cur_sum += cur_element;
                    if (cur_sum > max_sum){
                        max_sum = cur_sum;
                        level_max = cur_level;
                    }
                } else {
                    cur_sum += cur_element;
                }
            }
            //return level_max-1;
            return max_sum;
        }
    }

    public static void main(String[] args) throws Exception {
        Heap tree = new Heap();

        Scanner input = new Scanner(System.in);

        String[] data = input.nextLine().split(" ");
        for (String s : data) {
            tree.insert(Integer.parseInt(s));
        }

        System.out.print(sum_levelOrder(tree));
    }
}
