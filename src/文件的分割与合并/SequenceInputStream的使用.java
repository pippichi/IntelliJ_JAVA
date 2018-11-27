package 文件的分割与合并;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * SequenceInputStream 用于合并流
  */

public class SequenceInputStream的使用 {
    //目标文件名称
    private String aimName;
    //目标文件夹
    //private String aimPath;
    //子文件路径
    private List<String> src;
    //子文件名称
    private String srcName;

    public SequenceInputStream的使用(){
        src = new ArrayList<>();
    }

    public SequenceInputStream的使用(String aimName, List<String> src) {
        this();
        this.aimName = aimName;
        this.src = src;
    }

    //合并
    public void mergeFile() throws IOException {
        //选择流

        OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(aimName),true)); //输出流
        byte[] bytes = null;
        int len = 0;
        //SequenceInputStream的使用  选择流
        SequenceInputStream sis = null; //输入流
        //Enumerate   使用容器Vector
        Vector<InputStream> v1 = new Vector<>();

        for (int i = 0; i < src.size(); i++) {
            v1.add(new BufferedInputStream(new FileInputStream(new File(src.get(i)))));
        }
        sis = new SequenceInputStream(v1.elements());
        while((len=sis.read(bytes))!=-1){
            os.write(bytes,0,len);
            os.flush();
        }

        sis.close();
        os.close();
    }
}
