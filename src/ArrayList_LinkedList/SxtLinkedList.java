package ArrayList_LinkedList;


public class SxtLinkedList {
    private Node first;
    private Node last;

    private int size = 0;

    public void add(Object obj){
        Node n = new Node();
        if(first==null){
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            last = n;
        }else{
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);

            last = n;
        }
        size++;
    }
    public int getSize(){
        return size;
    }
    public Object get(int index){
        checkRange(index);
        Node temp = node(index);
        if(temp!=null){
            return temp.getObj();
        }
        return null;
    }
    public void checkRange(int index){
        if(index<0||index>=size){
            try{
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void remove(int index){
        checkRange(index);
        Node temp = node(index);
        if(temp!=null){
            Node up = temp.getPrevious();
            Node down = temp.getNext();
            down.setPrevious(up);
            up.setNext(down);
            size--;
        }
    }
    public void add(int index,Object obj){
        checkRange(index);
        Node temp = node(index);
        Node newNode = new Node();
        newNode.setObj(obj);
        if(temp!=null){
            Node up = temp.getPrevious();
            up.setNext(newNode);
            newNode.setPrevious(up);
            newNode.setNext(temp);
            temp.setPrevious(newNode);
            size++;
        }
    }
    public Node node(int index){
        Node temp = null;
        if(first!=null){
            if(index<(size >> 1)) {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.getNext();
                }
            }else{
                temp = last;
                for(int i=size-1;i>index;i--){
                    temp = temp.getPrevious();
                }
            }
        }
        return temp;
    }

    public static void main(String[] args){
        SxtLinkedList list = new SxtLinkedList();
        list.add("qyf");
        list.add(123);
        list.add(233);
        list.remove(1);
        list.add(1,13);
        System.out.println(list.get(1));
    }
}