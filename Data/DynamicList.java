package Data;

public class DynamicList extends StaticList {

    public DynamicList(){
        super(1);
    }

    public void pushFront(int key){
        if (full()){
            this.size *= 2;
            int[] newList = new int[this.size];
            if (this.index >= 0) System.arraycopy(this.list, 0, newList, 0, this.index);
            this.list = newList;
            pushFront(key);
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

    public void pushBack(int key){
        if (full()){
            this.size *= 2;
            int[] newList = new int[this.size];
            if (this.index >= 0) System.arraycopy(this.list, 0, newList, 0, this.index);
            this.list = newList;
            pushBack(key);
        } else {
            list[this.index] = key;
            this.index += 1;
        }
    }

    public static void main(String[] args) {
        DynamicList list = new DynamicList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(2);
        list.pushBack(2);

        System.out.println(list);
        System.out.println(list.size);
    }
}