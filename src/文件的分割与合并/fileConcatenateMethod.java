package 文件的分割与合并;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class fileConcatenateMethod {
    //目标文件名称
    private String aimName;
    //目标文件夹
    //private String aimPath;
    //子文件路径
    private List<String> src;
    //子文件名称
    private String srcName;

    public fileConcatenateMethod(){
        src = new ArrayList<>();
    }

    public fileConcatenateMethod(String aimName, List<String> src) {
        this();
        this.aimName = aimName;
        this.src = src;
    }

    //合并
    public void mergeFile() throws IOException {
        //选择流

        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(aimName),true),"utf-8"));
        String info = null;
        for (int i = 0; i < src.size(); i++) {
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src.get(i))),"utf-8"));
            while((info=is.readLine())!=null){
                os.write(info);
                os.newLine();
            }
            os.flush();

            is.close();
        }
        os.close();
    }
}
