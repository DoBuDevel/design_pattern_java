package design_pattern;

/*
 * Factory ���� (��������)
 * 
 * - ��ü�� ��
 * - Abstract class �� �������̽��� �پ��� ���� ����ü�� ���� ��쿡 ����ϸ� ����.
 * - Factory.create �������� ����. 
 * - ȣ��� new �� ������� �ʰ� .Create() �� ȣ���ϴ°��� �Ϲ����� ������� ����.
 * 
 */

interface Animal{
	public void printDescription();
}

class Test01 {
	public static Animal create(String animalName){
        if (animalName == null) {
            throw new IllegalArgumentException("null�� �� ������~");
        }
        if (animalName.equals("��")) {
            return new Cow();
        }else if (animalName.equals("�����")) {
            return new Cat();
        }else if (animalName.equals("��")) {
            return new Dog();
        }else{
            return null;
        }
    }
}

class Cow implements Animal {
    public void printDescription() {
        System.out.println("���� �� ��� ����");
    }
}

class Cat implements Animal {
    public void printDescription() {
        System.out.println("����� ����");
    }
}

class Dog implements Animal {
    public void printDescription() {
        System.out.println("�ַ� �� ��Ŵ");
    }
}

public class C03_Factory_method {
    public static void main(String[] args) {
        Animal a1= Test01.create("��");
        a1.printDescription();
        Animal a2= Test01.create("�����");
        a2.printDescription();
        Animal a3= Test01.create("��");
        a3.printDescription();
    }
}
