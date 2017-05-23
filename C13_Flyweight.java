package design_pattern;

import java.util.HashMap;
import java.util.Map;

import design_pattern.PersonFactory.Person;

/*
 * Flyweight ������ ���� �����ؼ� ��ü ������ �ٿ� ������ ����� �� �Դϴ�.
 * Ŭ�������� factory �� ����, factory������ �ڽ��� ���� ��ü�� ����, 
 * �̹� ������ �ִ� ��ü�� ���� ��û�� ������ ���� �����ϰ� �ִ� ��ü�� �����ְ�, 
 * ������ ���� ���� ���� ��û�ϸ� ���� ��ü�� ����� ���� ����Ʈ�� �߰���Ű�� �����ش�.
 */

class PersonFactory {
    private static Map<String, Person> map = new HashMap<String, Person>();
    public synchronized static Person getPerson(String name){
        if (!map.containsKey(name)) {
            Person tmp = new Person(name);
            map.put(name, tmp);
        }
        return map.get(name);
    }
    public static class Person {
        private final String name;
        private Person(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}

// Flyweight�� ����� factory�� ����ϴ� TestŬ���� 
public class C13_Flyweight {
    public static void main(String[] args) {
        Person p1 = PersonFactory.getPerson("ȫ�浿");
        Person p2 = PersonFactory.getPerson("�踻��");
        Person p3 = PersonFactory.getPerson("ȫ�浿");
        
        System.out.println(p1 == p2);
        System.out.println(p1 == p3);
    }
}
