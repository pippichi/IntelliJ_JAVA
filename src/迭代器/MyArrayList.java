package 迭代器;

/**
 * hasNext
 * next
 */

public class MyArrayList {
    private String[] elem = {"a","b","c","d","e","f"};
    private int size = elem.length;

    private int cursor = -1;

    public boolean hasNext(){
        return cursor+1<size;
    }
    public String next(){
        cursor++;
        return elem[cursor];
    }
    public void remove(){

    }

    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        while(list.hasNext()){
            String str = list.next();
            System.out.println(str);
        }
    }
}
