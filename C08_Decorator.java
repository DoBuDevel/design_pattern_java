package design_pattern;

/*
 * Decorator 패턴
 * 기존에 구현되어 있는 클래스에 기능을 추라하기 위한 패턴
 * 기존에 있던 클래스를 상속 받기 때문에 사용법이 크게 다르지 않음
 * 
 * - 데코레이터 패턴 에서 상위 클래스 , 하위클래스 의 관계
 *   1. 하위클래스는 상위 클래스의 형식을 멤버변수로 가짐. - 일반적으로 생성자의 인자로 받아서 멤버 변수로 세팅을 합니다. 
 *      별도의 setter 를 가지는 경우는 거의 없음.
 *   2. 하위클래스는 상위클래스를 상속 받아 상위클래스의 메쏘드를 이용함.
 * 
 * - 데코레이터가 일반적인 상속과 다른 점
 *   1. 데코레이터는 메쏘드의 확장개념, 멤버 변수로 받은 객체의 메쏘드를 이용하여 그 메쏘드를 확장하는 것이다.
 *   
 */

// 데코레이터
class Decorator {
   public String getMerong(){
       return "merong";
   }
}

// 데코레이터를 상속 받은 넘
class ChildDecorator extends Decorator{
   private Decorator decorator;
   public ChildDecorator(Decorator decorator){
       this.decorator = decorator;
   }
   @Override
   public String getMerong(){
       return "@" + decorator.getMerong() + "@";
   }
}

// 메인 클래스
public class C08_Decorator {
   public static void main(String[] args) {
       Decorator decorator = new Decorator();
       System.out.println(decorator.getMerong());
       Decorator child = new ChildDecorator(decorator);
       System.out.println(child.getMerong());
       Decorator child2 = new ChildDecorator(child);
       System.out.println(child2.getMerong());
   }
}
