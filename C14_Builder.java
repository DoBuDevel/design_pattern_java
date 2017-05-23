package design_pattern;

/* 
 * Builder 
 * 객체의 생성에 있어서 이런 복잡한 과정들을 분리해 내는 것이 Builder 패턴
 * 
 * 
 * Factory 를 사용하는 경우
 * 1.리턴 타입이 일정하지 않은 경우 
 * 2.대략 비슷하지만 멤버가 살짝 다른경우
 * 
 * builder 는 객체 생성과정의 복잡성을 떠넘김
 *  
 */


class Hero {
    private String armSource;
    private String legSource;
    private String name;
    
    public Hero(String name) {
        super();
        this.name = name;
    }
    public void setArmSource(String armSource) {
        this.armSource = armSource;
    }
    public void setLegSource(String legSource) {
        this.legSource = legSource;
    }
    public void showResult(){
        System.out.println(armSource +"로 만든 팔과 " + legSource +"로 만든 다리를 가진 " + name);
    }
}

// 복잡한 Hero 객체를 만들어내기 위한 객체 생성과정을 관리하는 Builder 인터페이스 

interface Builder {
    void makeArm();
    void makeLeg();
    Hero getResult();
}

// 복잡한 Hero 객체를 실제로 만들어내는 Builder의 구현체인 아이언맨 찍어내는 클래스
class BatmanBuilder implements Builder {
    private Hero batman;
    BatmanBuilder(){
        batman = new Hero("아이언맨");
    }
    public void makeArm() {
        batman.setArmSource("쇠");
    }
    public void makeLeg() {
        batman.setLegSource("쇠");
    }
    public Hero getResult() {
        return batman;
    }
}

// Builder를 관리해 주는 Director 
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public void build(){
        builder.makeArm();
        builder.makeLeg();
    }
    public Hero getHero(){
        return builder.getResult();
    }
}

// Director를 이용해 Hero를 찍어내는 Test클래스 
public class C14_Builder {
    public static void main(String[] args) {
        Builder builder = new BatmanBuilder();
        Director director = new Director(builder);
        director.build();
        Hero hero = director.getHero();
        hero.showResult();
    }
}
