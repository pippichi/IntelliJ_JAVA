package 装饰设计模式_类似扩音器;

public class Voice {
    private int voice = 10;

    public Voice(int voice) {
        this.voice = voice;
    }

    public Voice() {
    }

    public int getVoice() {
        return voice;
    }
    public void set(int voice){
        this.voice = voice;
    }

    public void say(){
        System.out.println(voice);
    }
}
