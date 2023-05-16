package Data;

public class Heap {

    DynamicList HeapArray = null;

    public Heap() {
        this.HeapArray = new DynamicList();
    }

    public int getSize() {
        return this.HeapArray.index;
    }

    public int getMaxSize() {
        return this.HeapArray.size;
    }

    public int getMax() {
        return this.HeapArray.list[0];
    }

    public int parent(int index) throws Exception {
        int indexParent = ((index+1) / 2)-1;
        if (indexParent >= this.getSize()){
            throw new Exception("No parent: Index "+indexParent+" out of bounds for size "+this.getSize());
        } else {
            return indexParent;
        }
    }

    public int leftChild(int index) throws Exception {
        int indexChildL = ((index+1) * 2)-1;
        if (indexChildL >= this.getSize()){
            throw new Exception("No left child: Index "+indexChildL+" out of bounds for size "+this.getSize());
        } else {
            return indexChildL;
        }
    }

    public int rightChild(int index) throws Exception {
        int indexChildR = (((index+1) * 2) + 1)-1;
        if (indexChildR >= this.getSize()){
            throw new Exception("No right child: Index "+indexChildR+" out of bounds for size "+this.getSize());
        } else {
            return indexChildR;
        }
    }

    public int levelNode(int index) {
        int i = index+1;
        return (int) ((Math.log(i) / Math.log(2)) + 1);
    }

    public void swiftUp(int index) throws Exception {
        if (index > 0){
            if (this.HeapArray.list[this.parent(index)] < this.HeapArray.list[index]){
                int temp = this.HeapArray.list[this.parent(index)];
                this.HeapArray.list[this.parent(index)] = this.HeapArray.list[index];
                this.HeapArray.list[index] = temp;
                this.swiftUp(this.parent(index));
            }
        }
    }

    public void insert(int key) throws Exception {
        this.HeapArray.pushBack(key);
        this.swiftUp(this.getSize()-1);
    }

    public void lineToInsert(String data) throws Exception {
        String[] dataList = data.split(" ");
        for (String s : dataList){
            this.insert(Integer.parseInt(s));
        }
    }

    public String levelOrder() throws Exception {
        if (this.HeapArray.empty()){
            throw new Exception("Empty Heap");
        } else {
            int l = 1;
            String result = "";
            for (int i = 0; i<this.getSize(); i++){
                int cur_element = this.HeapArray.list[i];
                int cur_level = this.levelNode(i);
                if ((l+1) == cur_level){
                    result += "\n"+cur_element + " ";
                    l += 1;
                } else {
                    result += cur_element + " ";
                }
            }
            return result;
        }
    }

    public void swiftDown(int index) throws Exception {
        int maxIndex = index;
        try{
            int l = this.leftChild(index);
            if (l < this.getSize() && this.HeapArray.list[l] > this.HeapArray.list[maxIndex]){
                maxIndex = l;
            }
        } catch (Exception ignored){}
        try{
            int r = this.rightChild(index);
            if (r < this.getSize() && this.HeapArray.list[r] > this.HeapArray.list[maxIndex]){
                maxIndex = r;
            }
        } catch (Exception ignored){}
        if (index != maxIndex){
            int temp = this.HeapArray.list[index];
            this.HeapArray.list[index] = this.HeapArray.list[maxIndex];
            this.HeapArray.list[maxIndex] = temp;
            this.swiftDown(maxIndex);
        }
    }

    public int extractMax() throws Exception {
        int result = this.HeapArray.list[0];
        int last = this.HeapArray.list[this.getSize()-1];
        this.HeapArray.list[0] = last;
        this.HeapArray.index -= 1;
        this.swiftDown(0);
        return result;
    }

    public void remove(int index) throws Exception {
        this.HeapArray.list[index] = this.getMax()+1;
        this.swiftUp(index);
        this.extractMax();
    }

    public void changePriority(int index, int new_Value) throws Exception {
        int old_Value = this.HeapArray.list[index];
        this.HeapArray.list[index] = new_Value;
        if (new_Value > old_Value){
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
            int value = this.extractMax();
            this.HeapArray.list[size-(i+1)] = value;
        }
        this.HeapArray.index = size;
        for (int i = 0; i < size/2; i++){
            int temp = this.HeapArray.list[i];
            this.HeapArray.list[i] = this.HeapArray.list[size-(i+1)];
            this.HeapArray.list[size-(i+1)] = temp;
        }
    }

    public void heapSortRev() throws Exception {
        int size = this.getSize();
        for (int i = 0; i < size; i++){
            int value = this.extractMax();
            this.HeapArray.list[size-(i+1)] = value;
        }
        this.HeapArray.index = size;
    }

    public static void main(String[] args) throws Exception {
        Heap myHeap = new Heap();
        String data = "15 10 8 21 4";
        String[] dataList = data.split(" ");
        for (String s : dataList){
            myHeap.HeapArray.pushBack(Integer.parseInt(s));
        }
        System.out.println(myHeap.levelOrder());
        System.out.println("-------");
        myHeap.makeHeap();
        System.out.println(myHeap.levelOrder());
        System.out.println("-------");
        myHeap.heapSort();
        System.out.println(myHeap.HeapArray);
        System.out.println("-------");
        myHeap.heapSortRev();
        System.out.println(myHeap.HeapArray);
    }
}
