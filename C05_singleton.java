package design_pattern;

/*
 * Singleton - �ϳ��� ��ü�� �ƹ��������� ���� �� �� �ִ�.
 * 
 * - �ν��Ͻ��� 1���� �����.
 * - private ������ ����� ���� �ʴ´�.
 * - private �� �ܺο����� ����ȣ���� ���� ������ ���� �Ͱ� ����� ���� �ΰ��� ����� �����մϴ�. �� �� 
 *   "�ν��Ͻ� " �Ѱ���� ��Ģ�� ��Ų��.
 * 
 * - Factory ���ϰ� ������ ������
 * - Singleton �� Factory �� Ư�� ���̽�.
 * - Factory �� �Ź� ��ü�� ���� ����, Singleton �� �Ѱ��� ���� ��û�� ���ö� ���� �ϳ��� ����
 * - �Ϲ������� Factory �� create �޼ҵ�,  Singleton �� getInstance �޽�带 ���
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
        System.out.println("Amethod���� ī���� ȣ�� " + sc.getNextInt() );
    }
    public void Bmethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Bmethod���� ī���� ȣ�� " + sc.getNextInt() );
    }
}

/*
 * �̱��� 1 
 * Ŭ���� �ε�� new �� ����� �׻� 1���� �ν��Ͻ��� ���´�. �ڵ尡 ª�� ����. ���ɵ� �ٸ� ����� ���� ����.
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
 * �̱��� 2
 * Ŭ���� �ε�� �ν��Ͻ��� ���� ���� �ʴ´�. getInstance() �� ó�� ȣ��ɶ� ����
 * but synchronized �� �ɷ� �־ ������ �� �����ϴ�. 
 * �ν��Ͻ��� ����� �ʿ䰡 ������ 1��° ��� �� ���� ����.
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
 * �̱��� 3
 * �̱��� 1 ���� - ���� �� �̱��� 2�� ���� instance �� ������ �ʴ� ������ �޾ƿ�
 * 
 * 2�� �����Ѵٰ� ����
 *   - ù��° �����̱� ������ single �� null �� single �� ����� ��������
 *   - �ι�° �����̸� ù��° ���ٿ��� single�� ������� ������ �ٷ� single ����
 * 
 * -> if(single == null) �� ���� ��� �������ϰ� �߻� , ������ singleton�� �����������
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
 * �̱��� 4
 * 
 * ����Ŭ������ ����ϴ¹�� , ���� 3���� ��������� singleton Ŭ������ �ڱ��ڽ��� Ÿ���� ������ ��������� ������ �ִµ�, 
 * 4�� ����Ŭ������ ������ �ִ�.
 * ���� Ŭ������ ȣ��Ǵ� ������ ���� ���� �Ǳ� ������, �ӵ��� ������ �ʿ������ �������� ����.
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
