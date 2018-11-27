package 装饰设计模式_类似扩音器;
/**
 * io流里面用到了装饰设计模式
 *
 * Amplify类就是对Voice类的装饰
 *  类与类之间的关系
 *  1、依赖：形参|局部变量
 *  2、关联：属性
 *          聚合：属性  整体与部分 不一致的生命周期 如人与手
 *          组合：属性  整体与部分 一致的生命周期  如人与大脑
 *  3、继承：父子类关系
 *  4、实现：接口与实现类关系
 */
public class Amplify {
    private Voice voice;//体现出类与类之间的关联

    public Amplify(Voice voice) {
        this.voice = voice;
    }
    public Amplify(){

    }
    public void say(){
        System.out.println(voice.getVoice()*1000);
    }
}
