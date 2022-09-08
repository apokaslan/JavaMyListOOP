import java.lang.Object;
import java.util.Arrays;
public class MyList <T>{
    private int capacity=10;
    private T[] array;
    private int index=0;

    MyList(){
        this.array=(T[])new Object()[capacity];
    }

    MyList(int capacity){
        this.capacity=capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int size(){
        return index;
    }
    public void add(T data){
        if (index==capacity){
            T[] newArray=(T[])new Object()[capacity*2];
            int i=0;
            for(T arr:this.array){
                newArray[i]=arr;
                i++;
            }
            this.array=newArray;
            this.capacity=this.capacity*2;
        }
        array[index]=data;
        index++;
    }
    public T get(int index){
        if (index<0||index>this.index){
            return null;
        }else {
            return array[index];
        }
    }

    public T remove(int index){
        this.index--;
        if (index<0||index>this.index){
            return null;
        }else {
            T deleteIndexValue=this.array[index];
            for(int i=index;i<this.index;i++){
                this.array[i]=this.array[i+1];
            }
            this.array[size()]=null;
            return deleteIndexValue;
        }
    }
    public T set(int index,T data){
        if (index<0||index>this.index){
            return null;
        }else {
            T setIndexValue=this.array[index];
            this.array[index]=data;
            return setIndexValue;}
    }
    public String toString(){
        return "My list : "+ Arrays.toString(array);
    }

    public int indexOf(T data){
        int dataIndex=0;
        boolean isThere=false;
        for(T arr : this.array){
            if(arr==data){
                isThere=true;
                break;
            }
            dataIndex++;
        }
        return isThere==true?dataIndex:-1;
    }
    public int lastIndexOf(T data){
        for (int i = size(); i>=0;i--){
            if(this.array[i]==data){
                return i;
            }
        }
        return -2;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public T[] toArray(){
        return this.array;
    }
    public void clear(){
        for(int i=0;i<this.size();i++){
            this.array[i]=null;
        }
    }
    public MyList<T> subList(int start, int finish) {
        MyList<T> list = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            list.add(this.array[i]);
        }
        return list;
    }

    // boolean contains(T data) : It tells whether the value given in the parameter
    // is in the array.
    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if (this.array[i] == data)
                return true;
        }
        return false;
    }
}
