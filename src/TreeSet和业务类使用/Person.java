package TreeSet和业务类使用;

public class Person {
    private final String name;
    private final int handsome;

    public Person(String name, int handsome) {
        this.name = name;
        this.handsome = handsome;
    }

    public Person() {
        /**
         * 当name和handsome不可更改时，无参构造必须先给他们一个值
         */
        name = null;
        handsome = 0;
    }

    public String getName() {
        return name;
    }


    public int getHandsome() {
        return handsome;
    }

    @Override
    public String toString(){
        return name + "'s handsome index is " + handsome + "\n";
    }
}
