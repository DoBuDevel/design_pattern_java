package design_pattern;

/*
 * Singleton - 하나의 객체를 아무곳에서나 접근 할 수 있다.
 * 
 * - 인스턴스가 1개만 생긴다.
 * - private 때문에 상속이 되지 않는다.
 * - private 는 외부에서의 직접호출을 통한 생성을 막는 것과 상속을 막는 두가지 기능을 수행합니다. 둘 다 
 *   "인스턴스 " 한개라는 원칙을 지킨다.
 * 
 * - Factory 패턴과 사용법이 유사함
 * - Singleton 은 Factory 의 특이 케이스.
 * - Factory 는 매번 객체를 만들어서 리턴, Singleton 은 한개만 만들어서 요청이 들어올때 마다 하나만 리턴
 * - 일반적으로 Factory 는 create 메소드,  Singleton 은 getInstance 메쏘드를 사용
 * - 
 * 
 */
class SingletonCounter {
    private static SingletonCounter singleton = new SingletonCounter();
    private int cnt = 0;
    private SingletonCounter(){
    }
    public static SingletonCounter getInstance(){
        return singleton;
    }
    public int getNextInt(){
        return ++cnt;
    }
}

public class C05_singleton  {
    public static void main(String[] args) {
    	C05_singleton t = new C05_singleton();
        t.Amethod();
        t.Bmethod();
    }
    public void Amethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Amethod에서 카운터 호출 " + sc.getNextInt() );
    }
    public void Bmethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Bmethod에서 카운터 호출 " + sc.getNextInt() );
    }
}

/*
 * 싱글톤 1 
 * 클래스 로드시 new 가 실행되 항상 1개의 인스턴스를 갖는다. 코드가 짧고 쉽다. 성능도 다른 방법에 비해 좋다.
 */

class Singleton1 {
    private static Singleton1 single = new Singleton1();
    public static Singleton1 getInstance(){
        return single;
    }
    private Singleton1(){
    }
}

/*
 * 싱글톤 2
 * 클래스 로드시 인스턴스가 생성 되지 않는다. getInstance() 가 처음 호출될때 생성
 * but synchronized 가 걸려 있어서 성능이 안 좋습니다. 
 * 인스턴스를 사용할 필요가 없을때 1번째 방법 에 비해 좋다.
 */
class Singleton2 {
    private static Singleton2 single;
    public static synchronized Singleton2 getInstance(){
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }
    private Singleton2(){
    }
}
/*
 * 싱글톤 3
 * 싱글톤 1 장점 - 성능 과 싱글톤 2의 장점 instance 를 만들지 않는 장점만 받아옴
 * 
 * 2번 접근한다고 가정
 *   - 첫번째 접근이기 때문에 single 은 null 임 single 을 만들고 빠져나감
 *   - 두번째 접근이면 첫번째 접근에서 single을 만들었기 때문에 바로 single 리턴
 * 
 * -> if(single == null) 이 없을 경우 성능저하가 발생 , 없으면 singleton이 보장되지않음
 * 
 */
class Singleton3 {
    private volatile static Singleton3 single;
    public static Singleton3 getInstance(){
        if (single == null) {
            synchronized(Singleton3.class) {
                if (single == null) {
                    single = new Singleton3();
                }
            }
        }
        return single;
    }
    private Singleton3(){
    }
}

/*
 * 싱글톤 4
 * 
 * 내부클래스를 사용하는방법 , 기존 3가지 방법에서는 singleton 클래스가 자기자신의 타입을 가지는 멤버변수를 가지고 있는데, 
 * 4는 내부클래스를 가지고 있다.
 * 내부 클래스가 호출되는 시점에 최초 생성 되기 때문에, 속도도 빠르고 필요없으면 생성하지 않음.
 */
class Singleton4 {
    private Singleton4(){
    }
    private static class SingletonHolder{
        static final Singleton4 single = new Singleton4();
    }
    public static Singleton4 getInstatnce(){
        return SingletonHolder.single;
    }
}
