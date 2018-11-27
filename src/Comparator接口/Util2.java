package Comparator接口;

public class Util2<T> implements java.lang.Comparable<T> {
    Integer o1;
    @Override
    public int compareTo(T o) {
        return -(o1-(Integer)o);
    }
}
