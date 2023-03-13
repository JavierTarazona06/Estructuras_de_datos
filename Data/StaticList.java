package Data;

import java.util.*;

public class StaticList{

    public int size;
    public int[] list;
    public int index;
    public  int positionFound;


    public StaticList(int size){
        this.size = size;
        this.list = new int[this.size];
        this.index = 0;
    }

    public void pushFront(int key){
        if (full()){
            throw new ArrayStoreException("Fail pushFront. La lista esta llena. No se pueden guardar más datos");
        } else {
            if (empty()){
                this.list[0] = key;
            } else {
                for (int i = this.index ; i > 0 ; i--){
                    this.list[i] = this.list[i-1];
                }
                this.list[0] = key;
            }
            this.index += 1;
        }
    }

    public int topFront(){
        if (empty()){
            throw new ArrayStoreException("Fail topFront. La lista esta vacía");
        } else {
            return this.list[0];
        }
    }

    public void popFront(){
        if (empty()){
            throw new ArrayStoreException("Fail popFront. La lista esta vacía");
        } else {
            for (int i = 0 ; i < this.index-1 ; i++){
                this.list[i] = this.list[i+1];
            }
            this.index -= 1;
        }
    }

    public void pushBack(int key){
        if (full()){
            throw new ArrayStoreException("Fail pushBack. La lista esta llena. No se pueden guardar más datos");
        } else {
            list[this.index] = key;
            this.index += 1;
        }
    }

    public int topBack(){
        if (empty()){
            throw new ArrayStoreException("Fail topBack. La lista esta vacía");
        } else {
            return this.list[this.index-1];
        }
    }

    public void popBack(){
        if (empty()){
            throw new ArrayStoreException("Fail popBack. La lista esta vacía");
        } else {
            this.index -= 1;
        }
    }

    public boolean full(){
        return (this.size)==this.index;
    }

    public boolean empty(){
        return this.index==0;
    }

    public boolean find(int key){
        boolean found = false;
        if (empty()){
            throw new ArrayStoreException("Fail find. La lista esta vacia");
        } else {
            for (int i=0; i<this.index; i++){
                if (this.list[i] == key){
                    found = true;
                    this.positionFound = i;
                    i = this.index;
                }
            }
        }
        return found;
    }

    public int findPosition(int key){
        boolean is = find(key);
        if (empty()){
            throw new ArrayStoreException("Fail find. La lista esta vacia");
        } else if (!is) {
            throw new ArrayStoreException("Fail findPosition. Key no esta en la lista");
        } else {
            return this.positionFound;
        }
    }

    public void erase(int key){
        if (empty()){
            throw new ArrayStoreException("Fail erase. La lista esta vacia");
        } else {
            int pos = findPosition(key);
            for (int i=0; i<this.index-1; i++){
                if (i>=pos){
                    this.list[i] = this.list[i+1];
                }
            }
            this.index -= 1;
        }
    }

    public void print(){
        StringBuilder list = new StringBuilder();
        for (int i=0; i<this.index; i++){
            list.append(this.list[i]).append(" ");
        }
        System.out.println(list);
    }

    public String toString(){
        StringBuilder list = new StringBuilder();
        for (int i=0; i<this.index; i++){
            list.append(this.list[i]).append(" ");
        }
        return list.toString();
    }

    public static void main(){
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese tamaño de Static List");
        int size = Integer.parseInt(input.nextLine());

        StaticList theList = new StaticList(size);

        theList.pushBack(1);
        theList.pushBack(2);
        theList.pushBack(3);
        theList.pushBack(4);

        System.out.println(theList);
    }
}