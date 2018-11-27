package lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1、map: 对于Stream中包含的元素使用给定的转换函数进行转换操作，
 * 新生成的Stream只包含转换生成的元素。这个方法有三个对于原始类型的变种方法，
 * 分别是：mapToInt，mapToLong和mapToDouble。
 * 这三个方法也比较好理解，比如mapToInt就是把原始Stream转换成一个新的Stream，这个新生成的Stream中的元素都是int类型。
 * 之所以会有这样三个变种方法，可以免除自动装箱/拆箱的额外消耗。
 *
 * 2、distinct: 对于Stream中包含的元素进行去重操作（去重逻辑依赖元素的equals方法），新生成的Stream中没有重复的元素。
 *
 * 3、flatMap：和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中。
 *
 * 4、 peek: 生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数。
 *
 * 5、 skip: 返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream。
 */

public class Lambda表达式详解 {
    public static void main(String[] args) {

//        方法引用写法
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames1 = proNames.stream().map(name->name.toLowerCase()).collect(Collectors.toList());
        List<String> lowercaseNames2 = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());

//        lambda表达式可使用的变量
        String waibu = "lambda:";
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(chuandi->{
            Long zidingyi = System.currentTimeMillis();
            return waibu+chuandi+"----:"+zidingyi;
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);

        //    在lambda中，this不是指向lambda表达式产生的那个SAM对象，而是声明它的外部对象。
        new Lambda表达式详解().whatThis();

//        方法引用
//        objectName::instanceMethod
//        ClassName::staticMethod
//        ClassName::instanceMethod
//        前两种方式类似，等同于把lambda表达式的参数直接当成instanceMethod|staticMethod的参数
//        来调用。比如System.out::println等同于x->System.out.println(x)；Math::max等同于(x, y)-
//        >Math.max(x,y)。

//        构造器引用
//        构造器引用语法如下：ClassName::new，把lambda表达式的参数当成ClassName构造器的参
//        数 。例如BigDecimal::new等同于x->new BigDecimal(x)。

//        Lists是Guava中的一个工具类
        List<Integer> nums = Arrays.asList(new Integer[]{1,2,null,3});
        int s = (int) nums.stream().filter(num->num!=null).count();
        System.out.println(s);

//        使用Stream静态方法来创建Stream
        //1. of方法：有两个overload方法，一个接受变长参数，一个接口单一值
        Stream<Integer> integerStream = Stream.of(1,2,3,5);
        Stream<String> stringStream = Stream.of("taobao");
        //2. generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        //等同于
        Stream.generate(Math::random);
        //等同于
        Stream.generate(()->Math.random());

        //3. iterate方法：也是生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
        Stream.iterate(2,item->item+1).limit(10).forEach(System.out::println);

//        flatMap给一段代码理解：
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3,4),
                Arrays.asList(5,6)
        );
        Stream<Integer> outputStream = inputStream.flatMap(childList->childList.stream());
        outputStream.forEach(n-> System.out.println(n));

//        整体调用例子：(包含peek、skip等)
        List<Integer> nums2 = Arrays.asList(new Integer[]{1,1,null,2,3,4,null,5,6,7,8,9,10});
        System.out.println("sum is:"+nums2
                .stream()
                .filter(num->num!=null)
                .distinct()
                .mapToInt(num->num*2)
                .peek(System.out::println)
                .skip(2)
                .limit(4)
                .sum());
        /*这段代码演示了上面介绍的所有转换方法（除了flatMap），
        简单解释一下这段代码的含义：给定一个Integer类型的List，
        获取其对应的Stream对象，然后进行过滤掉null，再去重，
        再每个元素乘以2，再每个元素被消费的时候打印自身，
        再跳过前两个元素，最后去前四个元素进行加和运算*/


//        可变汇聚
        /*可变汇聚对应的只有一个方法：collect，正如其名字显示的，
        它可以把Stream中的要有元素收集到一个结果容器中（比如Collection）。
        先看一下最通用的collect方法的定义（还有其他override方法）：
        <R> R collect(Supplier<R> supplier,
                BiConsumer<R, ? super T> accumulator,
                BiConsumer<R, R> combiner);
        先来看看这三个参数的含义：Supplier supplier是一个工厂函数，
        用来生成一个新的容器；BiConsumer accumulator也是一个函数，
        用来把Stream中的元素添加到结果容器中；BiConsumer combiner还是一个函数，
        用来把中间状态的多个结果容器合并成为一个（并发的时候会用到）。*/
        List<Integer> nums3 = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        List<Integer> numsWithoutNull = nums.stream().filter(num->num!=null)
                .collect(()->new ArrayList<>(),
                        (list,item)->list.add(item),
                        (list1,list2)->list1.addAll(list2));
        //等同于
        List<Integer> numsWithoutNullNew = nums.stream().filter(num->num!=null)
                .collect(Collectors.toList());

//        其他汇聚
        System.out.println(nums3);
        System.out.println("nums3 sum is:"+nums3.stream().filter(num->num!=null).reduce((count,num)->count+num).get());

        System.out.println("nums3 sum is:"+nums3.stream().filter(num->null!=num).reduce(4,(count,num)->count+num));

        System.out.println("nums3 count is:"+nums3.stream().filter(num->null!=num).count());

        /*– 搜索相关
        – allMatch：是不是Stream中的所有元素都满足给定的匹配条件
        – anyMatch：Stream中是否存在任何一个元素满足匹配条件
        – findFirst: 返回Stream中的第一个元素，如果Stream为空，返回空Optional
        – noneMatch：是不是Stream中的所有元素都不满足给定的匹配条件
        – max和min：使用给定的比较器（Operator），返回Stream中的最大|最小值*/
        List<Integer>ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(ints.stream().allMatch(item->item<100));
        ints.stream().max((o1,o2)->(o1.compareTo(o2))).ifPresent(System.out::println);
    }
//    在lambda中，this不是指向lambda表达式产生的那个SAM对象，而是声明它的外部对象。
    public void whatThis(){
        //转全小写
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(str->{
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }
}
