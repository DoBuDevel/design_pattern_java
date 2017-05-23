package design_pattern;

/*
 * Facade ����
 * �������� ������ �͵��� �ϳ��� �����ؼ� ���ϰ� �ٷ�� ��� �Դϴ�.
 * 
 * �������� ������ Ŭ������ ������ �ٷ� ������ Ŭ������ home Ŭ������ ����մϴ�.
 * Ŭ���̾�Ʈ�� Facade Ŭ������ ������ Ŭ������ �Ű澹�ϴ�.
 * 
 * �� ������ ����ϸ� �ּҴ����� Ŭ������ ������ �� �ִ�.
 */

// ���α���ǰ 1. TV
class TV {
    private boolean turnedOn = false;
    public void turnOn(){
        turnedOn = true;
        System.out.println("TV�� ��.");
    }
    public void turnOff(){
        turnedOn = false;
        System.out.println("TV�� ��.");
    }
    public boolean isTurnedOn(){
        return turnedOn;
    }
}

// ���α���ǰ 2. �����
class Audio {
    private boolean playing = false;
    public void play(){
        playing = true;
        System.out.println("������ ����.");
    }
    public void stop(){
        playing = false;
        System.out.println("������ ����");
    }
    public boolean isPlaying() {
        return playing;
    }
}

// ���α���ǰ 3. ���� 
class Light {
    private int lightness = 0;
    public int getLightness() {
        return lightness;
    }
    public void setLightness(int lightness) {
        System.out.println("��⸦ "+ lightness + "�� ����.");
        this.lightness = lightness;
    }
}

// Facade 
class Home {
    private Audio audio;
    private Light light;
    private TV tv;
    public Home(Audio audio, Light light, TV tv) {
        this.audio = audio;
        this.light = light;
        this.tv = tv;
    }
    public void enjoyTv(){
        System.out.println("==���� ����ϰ� TV����.");
        light.setLightness(2);
        tv.turnOn();
    }
    public void enjoyMusic(){
        System.out.println("==���� �ణ ��Ӱ��ϰ� ���ǵ��.");
        light.setLightness(1);
        audio.play();
    }
    public void goOut(){
        System.out.println("==TV����, ���ǵ� ����, �ҵ� ���� �����ϱ�.");
        if (tv.isTurnedOn()) {
            tv.turnOff();
        }
        if (audio.isPlaying()) {
            audio.stop();
        }
        light.setLightness(0);
    }
}

// �׽�Ʈ Ŭ���� 
public class C10_Facade {
    public static void main(String[] args) {
        TV tv = new TV();
        Audio audio = new Audio();
        Light light = new Light();
        
        Home home = new Home(audio, light, tv);
        
        home.enjoyTv();
        home.enjoyMusic();
        home.goOut();
    }
}
