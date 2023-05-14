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

    public int parent(int toSearch) throws Exception {
        int index = ((this.HeapArray.findPosition(toSearch)+1) / 2)-1;
        if (index >= this.getSize()){
            throw new Exception("No parent: Index "+index+" out of bounds for size "+this.getSize());
        } else {
            return this.HeapArray.list[index];
        }
    }

    public int leftChild(int toSearch) throws Exception {
        int index = ((this.HeapArray.findPosition(toSearch)+1) * 2)-1;
        if (index >= this.getSize()){
            throw new Exception("No left child: Index "+index+" out of bounds for size "+this.getSize());
        } else {
            return this.HeapArray.list[index];
        }
    }

    public int rightChild(int toSearch) throws Exception {
        int index = (((this.HeapArray.findPosition(toSearch)+1) * 2) + 1)-1;
        if (index >= this.getSize()){
            throw new Exception("No right child: Index "+index+" out of bounds for size "+this.getSize());
        } else {
            return this.HeapArray.list[index];
        }
    }

    public int levelNode(int element) {
        int i = this.HeapArray.findPosition(element)+1;
        return (int) ((Math.log(i) / Math.log(2)) + 1);
    }

    public void swiftUp(int toSwift) throws Exception {
        if (this.HeapArray.findPosition(toSwift)>0 && this.parent(toSwift) < toSwift){
            int temp = this.HeapArray.findPosition(toSwift);
            int parent = this.parent(toSwift);
            this.HeapArray.list[this.HeapArray.findPosition(parent)] = toSwift;
            this.HeapArray.list[temp] = parent;
            this.swiftUp(toSwift);
        }
    }

    public void insert(int key) throws Exception {
        this.HeapArray.pushBack(key);
        this.swiftUp(key);
        System.out.println(this.HeapArray);
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
                int cur_level = this.levelNode(cur_element);
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

    public void swiftDown(int toSwift) throws Exception {
        int maxChild = toSwift;
        try{
            int leftChild = this.leftChild(toSwift);
            if (leftChild > toSwift){
                maxChild = leftChild;
            }
        } catch (Exception ignored){}
        try{
            int rightChild = this.rightChild(toSwift);
            if (rightChild > toSwift){
                maxChild = rightChild;
            }
        } catch (Exception ignored){}
        if (toSwift != maxChild){
            int parentPos = this.HeapArray.findPosition(toSwift);
            int sonPos = this.HeapArray.findPosition(maxChild);
            this.HeapArray.list[parentPos] = maxChild;
            this.HeapArray.list[sonPos] = toSwift;
            this.swiftDown(maxChild);
            this.swiftDown(toSwift);
        }
    }

    public int extractMax() throws Exception {
        int result = this.HeapArray.list[0];
        int last = this.HeapArray.list[this.getSize()-1];
        this.HeapArray.list[0] = last;
        this.HeapArray.index -= 1;
        this.swiftDown(last);
        return result;
    }

    public void remove(int toRemove) throws Exception {
        int new_max = this.HeapArray.list[this.HeapArray.findPosition(toRemove)] = this.getMax()+1;
        this.swiftUp(new_max);
        this.extractMax();
    }

    public void changePriority(int index, int new_Value) throws Exception {
        int old_Value = this.HeapArray.list[index];
        this.HeapArray.list[index] = new_Value;
        if (new_Value > old_Value){
            this.swiftUp(new_Value);
        } else {
            this.swiftDown(new_Value);
        }
    }

    public static void main() throws Exception {
        Heap myHeap = new Heap();
        String data = "15 10 32 7 8 21 4 2 17";
        myHeap.lineToInsert(data);
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        myHeap.remove(8);
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        myHeap.changePriority(1,32);
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        myHeap.changePriority(2,1);
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        System.out.println("------");
        myHeap.extractMax();
        System.out.println(myHeap.levelOrder());
        System.out.println("------");
        String[] dataList = data.split(" ");
        for (String s : dataList){
            int p = Integer.parseInt(s);
            System.out.println(p);
            System.out.println();
            try{
                System.out.println(myHeap.parent(p));
            } catch (Exception e){
                System.out.println("null");
            }
            try{
                System.out.println(myHeap.leftChild(p));
            } catch (Exception e){
                System.out.println("null");
            }
            try{
                System.out.println(myHeap.rightChild(p));
            } catch (Exception e){
                System.out.println("null");
            }
            try{
                System.out.println(myHeap.levelNode(p));
            } catch (Exception e){
                System.out.println("null");
            }
            System.out.println("---------");
        }
    }
}
