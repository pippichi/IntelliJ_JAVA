package Map经典存储_分拣思路;


import java.util.*;

/**
 * 定义一个Student类，属性：name 姓名，classNumber 班号，score 成绩
 * 现在将若干Student对象放入list，请统计出每个班级的总分和平均分，分别打印出来
 */

public class MyDemo{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        studentExam(list);
        Map<String,ClassRoom> map = new HashMap<>();
        count(map,list);
        printScore(map);
    }
    public static void count(Map<String,ClassRoom> map,List<Student> list){
        for(Student student:list){
            String no = student.getNO();
            double score = student.getScore();
            ClassRoom room = map.get(no);
            if(room==null){
                room = new ClassRoom(no);
                map.put(no,room);
            }
            room.setTotal(room.getTotal()+score);
            room.getStu().add(student);
        }
    }

    public static void printScore(Map<String,ClassRoom> map){
        Set<Map.Entry<String,ClassRoom>> set = map.entrySet();
        Iterator<Map.Entry<String,ClassRoom>> iter = set.iterator();
        while(iter.hasNext()){
            Map.Entry<String,ClassRoom> entry = iter.next();
            ClassRoom room = entry.getValue();
            double averageScore = room.getAveScore();
            System.out.println(entry.getKey()+"---"+averageScore);
        }
    }

    public static void studentExam(List<Student> list){
        list.add(new Student("a","001",110));
        list.add(new Student("b","001",90));
        list.add(new Student("c","001",100));
        list.add(new Student("d","002",98));
        list.add(new Student("e","002",87));
        list.add(new Student("f","002",140));
        list.add(new Student("g","003",115));
        list.add(new Student("h","003",100));
    }
}