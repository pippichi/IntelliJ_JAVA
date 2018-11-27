package 文件的分割与合并;

import 工具类关闭流.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileSplitMethod {
    //分割文件目录
    private String filePath;
    //每块名称
    private List<String> blockPath;
    //每一块的文件名
    private String fileName;
    //块数
    private int size;
    //每块大小
    private long blockSize;
    //被分割文件大小
    private long length;

    public fileSplitMethod(){
        blockPath = new ArrayList<>();
    }
    public fileSplitMethod(String filePath,long blockSize){
        this();
        this.blockSize = blockSize;
        this.filePath = filePath;
        init();
    }

    public List<String> getBlockPath() {
        return blockPath;
    }

    public fileSplitMethod(String filePath){
        this(filePath,1024);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 初始化操作 计算 块数、确定文件名
     */
    public void init(){
        File src = null;
        //健壮性
        if(this.filePath==null||!((src=new File(this.filePath)).exists())){
            return;
        }
        if(src.isDirectory()){
            return;
        }
        this.fileName = src.getName();
        //计算块数
        length = src.length();
        if(this.blockSize>length){
            this.blockSize = length;
        }
        //确定块数
        this.size = (int)(Math.ceil(length*1.0/this.blockSize));
    }
    public void initPathName(String destPath){
        for(int i=0;i<size;i++){
            this.blockPath.add(destPath+"/"+this.fileName+".part"+i+".txt");
        }
    }

    /**
     * 文件的分割与合并
     * 0、第几块
     * 1、起始位置
     * 2、实际大小
     */
    public void split(String destPath) throws IOException {
        //确定文件路径
        initPathName(destPath);

        long beginPos = 0;
        long actualBlockSize = blockSize;

        //计算所有块的大小、位置、索引
        for(int i=0;i<size;i++){
            if(i==size-1){
                actualBlockSize = length - beginPos;
            }
            splitDetail(i,beginPos,actualBlockSize);
            beginPos+=actualBlockSize;
        }
    }

    /**
     * 文件的分割与合并
     * @param idx
     * @param beginPos
     * @param actualBlockSize
     */
    public void splitDetail(int idx,long beginPos,long actualBlockSize) throws IOException {
        //1、创建源
        File src = new File(filePath);//源文件
        File aim = new File(blockPath.get(idx));//目标文件
        RandomAccessFile raf = new RandomAccessFile(src,"r");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(aim));
        raf.seek(beginPos);
        byte[] temp = new byte[1024];
        int len = 0;
        /*方法一：
        int start = (int)actualBlockSize;
        while((len=raf.read(temp))!=-1){
            bos.write(temp,0,start);
        }*/
        //方法二：
        while((len=raf.read(temp))!=-1){
            if(actualBlockSize-len>=0){
                bos.write(temp,0,len);
                actualBlockSize-=len;//剩余量
            }else{
                bos.write(temp,0,(int)actualBlockSize);
                break;
            }
        }
        //bos.flush();
        //bos.close();
        FileUtil.closeAll(bos,raf);
    }
}
