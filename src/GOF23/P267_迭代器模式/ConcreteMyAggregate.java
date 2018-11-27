package GOF23.P267_迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public void addObj(Object obj){
        this.list.add(obj);
    }

    public void removeObj(Object obj){
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    //获得迭代器
    public MyIterator createIterator(){
        return new ConcreteIterator();
    }

    public void setList(List<Object> list) {
        this.list = list;
    }


    //使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator{

        private int cursor; //定义游标用于记录遍历时的位置

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if(cursor<list.size()){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor<list.size()?true:false;
        }

        @Override
        public boolean isFirst() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
