import java.util.*;

public class StaticList{

    int size;
    int[] list;
    int index;


    public StaticList(int size){
        this.size = size;
        this.list = new int[this.size];
        this.index = 0;
    }

    public void pushBack(int data){
        if (!full()){
            list[this.index] = data;
            this.index += 1;
            System.out.println("Pushed back in the static list...");
        } else {
            System.out.println("La lista está llena");
        }
    }

    public void popBack(){
        if (empty()){
            System.out.println("La lista esta vacía");
        } else {
            this.index -= 1;
            //this.index = 0;
            System.out.println("Deleted in static list");
        }
    }

    public void pushFront(int key){
        if (full()){
            System.out.println("La lista está llena");
        } else {
            if (empty()){
                this.list[0] = key;
                System.out.println("Pushed front in the static list...");
            } else {
                for (int i = this.index ; i > 0 ; i--){
                    this.list[i] = this.list[i-1];
                }
                this.list[0] = key;
                System.out.println("Pushed front in the static list...");
            }
            this.index += 1;
        }
    }

    public void popFront(){
        if (empty()){
            System.out.println("La lista esta vacía");
        } else {
            for (int i = 0 ; i < this.index-1 ; i++){
                this.list[i] = this.list[i+1];
            }
            System.out.println("Pop front in the static list...");
            this.index -= 1;
        }
    }

    //public void addBefore(int )

    public boolean full(){
        return (this.size)==this.index;
    }

    public boolean empty(){
        return this.index==0;
    }

    public void print(){
        for (int i=0; i<this.index; i++){
            System.out.print(this.list[i]+" ");
        }
        System.out.println("");
    }

    public String toString(){
        StringBuilder list = new StringBuilder();
        for (int i=0; i<this.index; i++){
            list.append(this.list[i]).append(" ");
        }
        return list.toString();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese tamaño de la lista");
        int size = input.nextInt();

        StaticList theList = new StaticList(size);

        theList.pushBack(1);
        theList.pushFront(2);
        theList.pushFront(3);
        theList.pushFront(4);
        theList.pushFront(5);
        theList.popFront();

        System.out.println(theList);
    }
}