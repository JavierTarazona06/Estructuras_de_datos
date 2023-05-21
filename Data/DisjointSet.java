package Data;

public class DisjointSet{

    StaticList parent;
    StaticList rank;

    public DisjointSet(int size){
        this.parent = new StaticList(size);
        this.rank = new StaticList(size);
    }

    public void makeSet(){
        for (int i=0; i<this.parent.size; i++){
            this.parent.list[i] = i;
            this.parent.index = i+1;
            this.rank.list[i] = 0;
            this.rank.index = i+1;
        }
    }

    public void makeSet(int i){
        this.parent.list[i] = i;
        this.parent.index = i+1;
        this.rank.list[i] = 0;
        this.rank.index = i+1;

    }

    public int findSlow(int i){
        while (i != this.parent.list[i]){
            i = this.parent.list[i];
        }
        return i;
    }

    public int find(int i){
        if (i != this.parent.list[i]){
            this.parent.list[i] = this.find(this.parent.list[i]);
        }
        return this.parent.list[i];
    }

    public void union(int i, int j){
        int i_id = this.find(i);
        int j_id = this.find(j);
        if (i_id == j_id){return;}
        if (this.rank.list[i_id] > this.rank.list[j_id]){
            this.parent.list[j_id] = i_id;
        } else {
            this.parent.list[i_id] = j_id;
            if (this.rank.list[i_id] == this.rank.list[j_id]){
                this.rank.list[j_id] = this.rank.list[j_id] + 1;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet mySet = new DisjointSet(8);
        mySet.makeSet();
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
        System.out.println("--------");
        mySet.union(2,7);
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
        System.out.println("--------");
        mySet.union(7,4);
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
        System.out.println("--------");
        mySet.union(3,5);
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
        System.out.println("--------");
        mySet.union(7,5);
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
        System.out.println("--------");
        System.out.println(mySet.find(2));
        System.out.println("0 1 2 3 4 5 6 7");
        System.out.println(mySet.parent);
        System.out.println(mySet.rank);
    }
}
