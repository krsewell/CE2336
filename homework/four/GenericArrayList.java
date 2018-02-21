package homework.four;

public class<T> GenericArrayList {
    private ArrayList<T> _list = new ArrayList();

    public GenericArrayList(){}
    public GenericArrayList(T[] init) {
        this.add(init);
    }

    public void sort() {
        //this._list bubble sort
        for (int i = 0; i < this._list.size()-1; i++) {
            if (this._list.get(i) > this._list.get(i+1)) {
                this.swap(i,i+1);
            }
        }
    }

    public void swap(int x, int y) {
        T temp = this._list.get(x);
        this._list.set(x,this._list.get(y));
        this._list.set(y,temp);
    }

    public int search(T what) {
        for (int i = 0; i < this._list.size()l i++) {
            if (this._list.get(i) == what) {
                return i;
            }
        }
    }

    public void add(T[] init) {
        for (int i = 0; i < init.size(); i++) {
            this._list.add(init[i]);
        }
    }

    public static void main(String[] args) {
        Integer test = new GenericArrayList();
        String test2 = new GenericArrayList();
        String[] str = {"asdf","fdas","foo","bar"};
        Integer[] num = {1,2,3,4};

        test.add(num);
        test2.add(str);
        
        System.exit(0);

    }
}