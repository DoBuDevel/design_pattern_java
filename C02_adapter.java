package design_pattern;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/*
 * Adapter 패턴 - 구성, 위임을 통한 방법
 * 
 * 어떤 오브젝트를 캐스팅이 불가능한 다른 클래스의 형태로 변환 시켜줌
 * 
 * 외관상 다른 형태로 변환 하기 위해, 직접하려하는 것은 아님
 * 
 * JAVA API 에 있는 Adapter
 * 
 * JDK 는 제공 하지 않음, 알아서 상속해서 써야됨.
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
	 * 내가쓸 goodMethod
	 */
    public static void goodMethod(Enumeration<String> enu){
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
    }
 
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("한성");
        list.add("커세어");
        list.add("로지텍");
        /*
         * adaptor 를 가져다 씀
         */
        Enumeration<String> ite = new C02_adapter(list.iterator());
        Test.goodMethod(ite);
   }
}

/*
 * Adapter 클래스를 만들지 않고 method 로 만드는 방법 (Adaptor 클래스는 아님, 하지만 많이쓰임)
 *  
 * - 인자가 final 로 전달 되어야함, 아닐경우 컴파일 에러가 남
 * - final로 정의 한다는 뜻은 read-only 읽기만 제공
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

