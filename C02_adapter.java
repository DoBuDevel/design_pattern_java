package design_pattern;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/*
 * Adapter ���� - ����, ������ ���� ���
 * 
 * � ������Ʈ�� ĳ������ �Ұ����� �ٸ� Ŭ������ ���·� ��ȯ ������
 * 
 * �ܰ��� �ٸ� ���·� ��ȯ �ϱ� ����, �����Ϸ��ϴ� ���� �ƴ�
 * 
 * JAVA API �� �ִ� Adapter
 * 
 * JDK �� ���� ���� ����, �˾Ƽ� ����ؼ� ��ߵ�.
 * 
 */
public class C02_adapter  implements Enumeration<String>{
    private Iterator<String> iter;
    public C02_adapter(Iterator<String> iter) {
        this.iter = iter;
    }
    public boolean hasMoreElements() {
        return iter.hasNext();
    }
    public String nextElement() {
        return iter.next();
    }
}

class Test {
	/*
	 * ������ goodMethod
	 */
    public static void goodMethod(Enumeration<String> enu){
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
    }
 
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("�Ѽ�");
        list.add("Ŀ����");
        list.add("������");
        /*
         * adaptor �� ������ ��
         */
        Enumeration<String> ite = new C02_adapter(list.iterator());
        Test.goodMethod(ite);
   }
}

/*
 * Adapter Ŭ������ ������ �ʰ� method �� ����� ��� (Adaptor Ŭ������ �ƴ�, ������ ���̾���)
 *  
 * - ���ڰ� final �� ���� �Ǿ����, �ƴҰ�� ������ ������ ��
 * - final�� ���� �Ѵٴ� ���� read-only �б⸸ ����
 */

/*
public static Enumeration<String> iteratorToEnumeration(final Iterator<String> iter) {
    return new Enumeration<String>() {
        public boolean hasMoreElements() {
            return iter.hasNext();
        }

        public String nextElement() {
            return iter.next();
        }
   };
}
*/

