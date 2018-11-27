package GOF23.P262_组合模式;

public class cilent {
    public static void main(String[] args) {
        AbstractFile f2,f3,f4,f5;
        Folder f1 = new Folder("我的收藏");

        f2 = new ImageFile("头像.jpg");
        f3 = new TxtFile("Hello.txt");

        f1.add(f2);
        f1.add(f3);

//        f2.killVirus();
//        f1.killVirus();
        Folder f11 = new Folder("电影");
        f4 = new VideoFile("笑傲江湖.avi");
        f5 = new VideoFile("神雕侠侣.avi");
        f11.add(f4);
        f11.add(f5);
        f1.add(f11);

        f1.killVirus();
    }
}
