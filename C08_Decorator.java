package design_pattern;

/*
 * Decorator ����
 * ������ �����Ǿ� �ִ� Ŭ������ ����� �߶��ϱ� ���� ����
 * ������ �ִ� Ŭ������ ��� �ޱ� ������ ������ ũ�� �ٸ��� ����
 * 
 * - ���ڷ����� ���� ���� ���� Ŭ���� , ����Ŭ���� �� ����
 *   1. ����Ŭ������ ���� Ŭ������ ������ ��������� ����. - �Ϲ������� �������� ���ڷ� �޾Ƽ� ��� ������ ������ �մϴ�. 
 *      ������ setter �� ������ ���� ���� ����.
 *   2. ����Ŭ������ ����Ŭ������ ��� �޾� ����Ŭ������ �޽�带 �̿���.
 * 
 * - ���ڷ����Ͱ� �Ϲ����� ��Ӱ� �ٸ� ��
 *   1. ���ڷ����ʹ� �޽���� Ȯ�尳��, ��� ������ ���� ��ü�� �޽�带 �̿��Ͽ� �� �޽�带 Ȯ���ϴ� ���̴�.
 *   
 */

// ���ڷ�����
class Decorator {
   public String getMerong(){
       return "merong";
   }
}

// ���ڷ����͸� ��� ���� ��
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

// ���� Ŭ����
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
