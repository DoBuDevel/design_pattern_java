package design_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * http://iilii.egloos.com/ -출처
 * 
 *  iterator 패턴
 *  
 *  집합체 (array, List, Set, Map) 와 개별 원소들을 분리 시켜 생각할 수 있다. 
 *  그 집합체가 어떤 클래스의 인스턴스 인지 신경 쓰지 않아도 된다.
 *  
 *  Enumeration 과  Iterator
 *  
 *  Enumeration 은 bolean hasMoreElements() nextElement() 를 제공
 *  Iterator next(), hasNext() 에 대응 된다.
 *  
 *  차이점   1. Iterator 는 remove() 를 제공 한다.
 *        2. Iterator 는 타이핑 을 덜한다.
 *        3. Enumeration 이 먼저 나왔다. 
 *
 */
public class C01_iterator implements Iterable<String> {
	private List<String> list = new ArrayList<String>();

	public void add(String name) {
		list.add(name);
	}

	public Iterator<String> iterator() {
		/* 시퀀스는 hasNext() 가 아니라 next() 에서 증가 시킨다.
		 * (hasNext() 를 호출하고 next() 를 한번 더 호출 할 수 있기 때문이다.
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
		 * 변수를 뽑아내는데 keyBord라는 변수를 쓰지 않는다.
		 */
		C01_iterator keyBord = new C01_iterator();
		keyBord.add("한성");
		keyBord.add("커세어");
		keyBord.add("로지텍");

		Iterator<String> iterator = keyBord.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
	}
}
