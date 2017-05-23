package design_pattern;

/*
 * Facade 패턴
 * 여러가지 복잡한 것들을 하나로 간주해서 편하게 다루는 방법 입니다.
 * 
 * 실질적인 저차원 클래스의 조합은 바로 고차원 클래스인 home 클래스가 담당합니다.
 * 클라이언트인 Facade 클래스는 고차원 클래스만 신경씁니다.
 * 
 * 이 패턴을 사용하면 최소단위로 클래스를 설계할 수 있다.
 */

// 내부구성품 1. TV
class TV {
    private boolean turnedOn = false;
    public void turnOn(){
        turnedOn = true;
        System.out.println("TV를 켬.");
    }
    public void turnOff(){
        turnedOn = false;
        System.out.println("TV를 끔.");
    }
    public boolean isTurnedOn(){
        return turnedOn;
    }
}

// 내부구성품 2. 오디오
class Audio {
    private boolean playing = false;
    public void play(){
        playing = true;
        System.out.println("음악을 연주.");
    }
    public void stop(){
        playing = false;
        System.out.println("음악을 멈춤");
    }
    public boolean isPlaying() {
        return playing;
    }
}

// 내부구성품 3. 전등 
class Light {
    private int lightness = 0;
    public int getLightness() {
        return lightness;
    }
    public void setLightness(int lightness) {
        System.out.println("밝기를 "+ lightness + "로 변경.");
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
        System.out.println("==불을 밝게하고 TV보기.");
        light.setLightness(2);
        tv.turnOn();
    }
    public void enjoyMusic(){
        System.out.println("==불을 약간 어둡게하고 음악듣기.");
        light.setLightness(1);
        audio.play();
    }
    public void goOut(){
        System.out.println("==TV끄고, 음악도 끄고, 불도 끄고 외출하기.");
        if (tv.isTurnedOn()) {
            tv.turnOff();
        }
        if (audio.isPlaying()) {
            audio.stop();
        }
        light.setLightness(0);
    }
}

// 테스트 클래스 
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
