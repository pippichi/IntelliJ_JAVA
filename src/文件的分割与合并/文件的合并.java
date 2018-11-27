package 文件的分割与合并;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 文件的合并 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("D:/Java test/test/test1.txt");
        list.add("D:/Java test/test/test2.txt");
        list.add("D:/Java test/test/ball1.java");
        String aim = "D:/Java test/test";
        fileConcatenateMethod f1 = new fileConcatenateMethod(aim+"/aim.txt",list);
        f1.mergeFile();
        fileSplitMethod splitFile = new fileSplitMethod("D:/Java test/test/test3.txt",20);
        splitFile.split("D:/Java test/test");
        fileConcatenateMethod f2 = new fileConcatenateMethod(aim+"/aim2.txt",splitFile.getBlockPath());
        f2.mergeFile();
    }
}
