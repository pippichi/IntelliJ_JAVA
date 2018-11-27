package 文件的分割与合并;

import java.io.*;

/**
 * 文件分割思路
 * 1、分割的块数 size
 * 2、每一块的大小 blockSize
 *      最后一块的大小=总的文件大小-(n-1)*blockSize
 */
public class 文件的分割 {
    public static void main(String[] args) throws IOException {
        fileSplitMethod splitFile = new fileSplitMethod("D:/Java test/test/test3.txt",20);
        splitFile.split("D:/Java test/test");
    }
}
