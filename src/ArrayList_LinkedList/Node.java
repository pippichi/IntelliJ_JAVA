package ArrayList_LinkedList;

import java.util.Optional;

class Node {
    private Node previous;
    private Object obj;
    private Node next;

    public Node(){}
    public Node(Node previous,Object obj,Node next){
        super();
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrevious(){
        return previous;
    }
    public void setPrevious(Node o){
        this.previous = o;
    }
    public Object getObj(){
        return obj;
    }
    public void setObj(Object o){
        this.obj = o;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node o){
        this.next = o;
    }
}
