package design_pattern;

/*
 * Factory 패턴 (공장패턴)
 * 
 * - 객체를 찍어냄
 * - Abstract class 나 인터페이스에 다양한 하위 구현체가 있을 경우에 사용하면 좋음.
 * - Factory.create 형식으로 만듬. 
 * - 호출시 new 를 사용하지 않고 .Create() 로 호출하는것이 일반적인 방법과의 차이.
 * 
 */

interface Animal{
	public void printDescription();
}

class Test01 {
	public static Animal create(String animalName){
        if (animalName == null) {
            throw new IllegalArgumentException("null은 안 되지롱~");
        }
        if (animalName.equals("소")) {
            return new Cow();
        }else if (animalName.equals("고양이")) {
            return new Cat();
        }else if (animalName.equals("개")) {
            return new Dog();
        }else{
            return null;
        }
    }
}

class Cow implements Animal {
    public void printDescription() {
        System.out.println("우유 및 고기 제공");
    }
}

class Cat implements Animal {
    public void printDescription() {
        System.out.println("쥐잡기 선수");
    }
}

class Dog implements Animal {
    public void printDescription() {
        System.out.println("주로 집 지킴");
    }
}

public class C03_Factory_method {
    public static void main(String[] args) {
        Animal a1= Test01.create("소");
        a1.printDescription();
        Animal a2= Test01.create("고양이");
        a2.printDescription();
        Animal a3= Test01.create("개");
        a3.printDescription();
    }
}
