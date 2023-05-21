package Data;

public class HeapMin extends Heap{

    public HeapMin() {
        super();
    }

    public int getMin() {
        return this.array.list[0];
    }

    public void swiftUp(int index) throws Exception {
        if (index > 0){
            if (this.array.list[this.parent(index)] > this.array.list[index]){
                int temp = this.array.list[this.parent(index)];
                this.array.list[this.parent(index)] = this.array.list[index];
                this.array.list[index] = temp;
                this.swiftUp(this.parent(index));
            }
        }
    }

    public void insert(int key) throws Exception {
        this.array.pushBack(key);
        this.swiftUp(this.getSize()-1);
    }

    public void swiftDown(int index) throws Exception {
        int minIndex = index;
        try{
            int l = this.leftChild(index);
            if (l < this.getSize() && this.array.list[l] < this.array.list[minIndex]){
                minIndex = l;
            }
        } catch (Exception ignored){}
        try{
            int r = this.rightChild(index);
            if (r < this.getSize() && this.array.list[r] < this.array.list[minIndex]){
                minIndex = r;
            }
        } catch (Exception ignored){}
        if (index != minIndex){
            int temp = this.array.list[index];
            this.array.list[index] = this.array.list[minIndex];
            this.array.list[minIndex] = temp;
            this.swiftDown(minIndex);
        }
    }

    public int extractMin() throws Exception {
        int result = this.array.list[0];
        int last = this.array.list[this.getSize()-1];
        this.array.list[0] = last;
        this.array.index -= 1;
        this.swiftDown(0);
        return result;
    }

    public void remove(int index) throws Exception {
        this.array.list[index] = this.getMin()-1;
        this.swiftUp(index);
        this.extractMin();
    }

    public void changePriority(int index, int new_Value) throws Exception {
        int old_Value = this.array.list[index];
        this.array.list[index] = new_Value;
        if (new_Value < old_Value){
            this.swiftUp(index);
        } else {
            this.swiftDown(index);
        }
    }

    public void makeHeap() throws Exception {
        int node_interno_index = this.parent(this.getSize()-1);
        for (int i = node_interno_index; i >= 0; i--){
            this.swiftDown(i);
        }
    }

    public void heapSort() throws Exception {
        int size = this.getSize();
        for (int i = 0; i < size; i++){
            int value = this.extractMin();
            this.array.list[size-(i+1)] = value;
        }
        this.array.index = size;
        for (int i = 0; i < size/2; i++){
            int temp = this.array.list[i];
            this.array.list[i] = this.array.list[size-(i+1)];
            this.array.list[size-(i+1)] = temp;
        }
    }

    public void heapSortRev() throws Exception {
        int size = this.getSize();
        for (int i = 0; i < size; i++){
            int value = this.extractMin();
            this.array.list[size-(i+1)] = value;
        }
        this.array.index = size;
    }

    public static void main() throws Exception {
        HeapMin myHeap = new HeapMin();
        String data = "15 10 8 21 4";
        String[] dataList = data.split(" ");
        for (String s : dataList){
            myHeap.array.pushBack(Integer.parseInt(s));
        }
        System.out.println(myHeap.levelOrder());
        System.out.println("-------");
        myHeap.makeHeap();
        System.out.println(myHeap.levelOrder());
        System.out.println("-------");
        myHeap.heapSort();
        System.out.println(myHeap.array);
        System.out.println("-------");
        myHeap.heapSortRev();
        System.out.println(myHeap.array);
    }
}
