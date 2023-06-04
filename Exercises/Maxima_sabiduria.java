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
            for (int i = 0; i<tree.getSize(); i++){
                int cur_element = tree.array.list[i];
                int cur_level = tree.levelNode(i);
                if ((l+1) == cur_level){
                    if (cur_sum > max_sum){
                        max_sum = cur_sum;
                        cur_sum = 0;
                        level_max = cur_level;
                    }
                    cur_sum = 0;
                    cur_sum = cur_element;
                    result += "\n"+cur_element + " ";
                    l += 1;
                } else {
                    result += cur_element + " ";
                    cur_sum += cur_element;
                }
            }
            return level_max-1;
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
