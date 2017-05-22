package design_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * http://iilii.egloos.com/ -��ó
 * 
 *  iterator ����
 *  
 *  ����ü (array, List, Set, Map) �� ���� ���ҵ��� �и� ���� ������ �� �ִ�. 
 *  �� ����ü�� � Ŭ������ �ν��Ͻ� ���� �Ű� ���� �ʾƵ� �ȴ�.
 *  
 *  Enumeration ��  Iterator
 *  
 *  Enumeration �� bolean hasMoreElements() nextElement() �� ����
 *  Iterator next(), hasNext() �� ���� �ȴ�.
 *  
 *  ������   1. Iterator �� remove() �� ���� �Ѵ�.
 *        2. Iterator �� Ÿ���� �� ���Ѵ�.
 *        3. Enumeration �� ���� ���Դ�. 
 *
 */
public class C01_iterator implements Iterable<String> {
	private List<String> list = new ArrayList<String>();

	public void add(String name) {
		list.add(name);
	}

	public Iterator<String> iterator() {
		/* �������� hasNext() �� �ƴ϶� next() ���� ���� ��Ų��.
		 * (hasNext() �� ȣ���ϰ� next() �� �ѹ� �� ȣ�� �� �� �ֱ� �����̴�.
		 */
		return new Iterator<String>() {
			int seq = 0;
			
			public boolean hasNext() {
				return seq < list.size();
			}
			
			public String next() {
				return list.get(seq++);
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] arg) {
		
		/*
		 * ������ �̾Ƴ��µ� keyBord��� ������ ���� �ʴ´�.
		 */
		C01_iterator keyBord = new C01_iterator();
		keyBord.add("�Ѽ�");
		keyBord.add("Ŀ����");
		keyBord.add("������");

		Iterator<String> iterator = keyBord.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
	}
}
