package design_pattern;

/* 
 * Builder 
 * ��ü�� ������ �־ �̷� ������ �������� �и��� ���� ���� Builder ����
 * 
 * 
 * Factory �� ����ϴ� ���
 * 1.���� Ÿ���� �������� ���� ��� 
 * 2.�뷫 ��������� ����� ��¦ �ٸ����
 * 
 * builder �� ��ü ���������� ���⼺�� ���ѱ�
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
        System.out.println(armSource +"�� ���� �Ȱ� " + legSource +"�� ���� �ٸ��� ���� " + name);
    }
}

// ������ Hero ��ü�� ������ ���� ��ü ���������� �����ϴ� Builder �������̽� 

interface Builder {
    void makeArm();
    void makeLeg();
    Hero getResult();
}

// ������ Hero ��ü�� ������ ������ Builder�� ����ü�� ���̾�� ���� Ŭ����
class BatmanBuilder implements Builder {
    private Hero batman;
    BatmanBuilder(){
        batman = new Hero("���̾��");
    }
    public void makeArm() {
        batman.setArmSource("��");
    }
    public void makeLeg() {
        batman.setLegSource("��");
    }
    public Hero getResult() {
        return batman;
    }
}

// Builder�� ������ �ִ� Director 
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

// Director�� �̿��� Hero�� ���� TestŬ���� 
public class C14_Builder {
    public static void main(String[] args) {
        Builder builder = new BatmanBuilder();
        Director director = new Director(builder);
        director.build();
        Hero hero = director.getHero();
        hero.showResult();
    }
}
