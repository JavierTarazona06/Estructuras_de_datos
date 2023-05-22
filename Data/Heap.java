package Data;

public class Heap {

    public DynamicList array = null;

    public Heap() {
        this.array = new DynamicList();
    }

    public int getSize() {
        return this.array.index;
    }

    public int getMaxSize() {
        return this.array.size;
    }

    public int parent(int index) throws Exception {
        int indexParent = ((index + 1) / 2)-1;
        if (indexParent >= this.getSize()){
            throw new Exception("No parent: Index "+ indexParent +" out of bounds for size "+this.getSize());
        } else {
            return indexParent;
        }
    }

    public int leftChild(int index) throws Exception {
        int indexChildL = ((index + 1) * 2)-1;
        if (indexChildL >= this.getSize()){
            throw new Exception("No left child: Index "+indexChildL+" out of bounds for size "+this.getSize());
        } else {
            return indexChildL;
        }
    }

    public int rightChild(int index) throws Exception {
        int indexChildR = (((index + 1) * 2) + 1)-1;
        if (indexChildR >= this.getSize()){
            throw new Exception("No right child: Index "+indexChildR+" out of bounds for size "+this.getSize());
        } else {
            return indexChildR;
        }
    }

    public int levelNode(int index) {
        int i = index + 1;
        return (int) ((Math.log(i) / Math.log(2)) + 1);
    }

    public void insert(int key) throws Exception {
        this.array.pushBack(key);
    }

    public void lineToInsert(String data) throws Exception {
        String[] dataList = data.split(" ");
        for (String s : dataList){
            this.insert(Integer.parseInt(s));
        }
    }

    public String levelOrder() throws Exception {
        if (this.array.empty()){
            throw new Exception("Empty Heap");
        } else {
            int l = 1;
            String result = "";
            for (int i = 0; i<this.getSize(); i++){
                int cur_element = this.array.list[i];
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

    public String inOrder(int index) throws Exception {
        if (index == this.getSize()){
            return "";
        } else {
            String result = "";
            try{
                result += this.inOrder(this.leftChild(index));
            } catch (Exception ignored){}
            int num = this.array.list[index];
            result += num + " ";
            try{
                result += this.inOrder(this.rightChild(index));
            } catch (Exception ignored){}
            return result;
        }
    }

    public String inOrder() throws Exception {
        return this.inOrder(0);
    }

    public String preOrder(int index) throws Exception {
        if (index == this.getSize()){
            return "";
        } else {
            String result = "";
            int num = this.array.list[index];
            result += num + " ";
            try{
                result += this.preOrder(this.leftChild(index));
            } catch (Exception ignored){}
            try{
                result += this.preOrder(this.rightChild(index));
            } catch (Exception ignored){}
            return result;
        }
    }

    public String preOrder() throws Exception {
        return this.preOrder(0);
    }

    public String posOrder(int index) throws Exception {
        if (index == this.getSize()){
            return "";
        } else {
            String result = "";
            try{
                result += this.posOrder(this.leftChild(index));
            } catch (Exception ignored){}
            try{
                result += this.posOrder(this.rightChild(index));
            } catch (Exception ignored){}
            int num = this.array.list[index];
            result += num + " ";
            return result;
        }
    }

    public String posOrder() throws Exception {
        return this.posOrder(0);
    }

    public void remove(int index) throws Exception {
        if (index == (this.getSize()-1)){
            this.array.index -= 1;
        }else if ((index) < (this.getSize()-1)){
            this.array.list[index] = this.array.list[index + 1];
            this.remove(index+1);
        } else {
            throw new Exception("Index " + index + " out of bounds for size: " + this.getSize());
        }
    }

    public void changePriority(int index, int new_Value) throws Exception {
        this.array.list[index] = new_Value;
    }
}
