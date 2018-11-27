package Comparator接口;

public class Util<T> implements java.util.Comparator<T> {
    @Override
    public int compare(T s1,T s2) {
        return -((Integer) s1 - (Integer) s2);
    }
}
