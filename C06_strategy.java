package design_pattern;

/*
 * Strategy 패턴
 * 
 * Templete - 상속을 을 이용해서 구현 , <-> Strategy 패턴  구성을 이용.
 * 
 * Templete 하위클래스에서 바뀌는 부분을 처리 <-> Strategy 는 바뀌는 부분을 인터페이스로 분리하여 처리, 인터페이스의 구현체를 바꿈으로서 로직 변경
 * 
 * Templete 가지고 있는 상위 클래스 였지만, Strategy 에서는 인터페이스를 사용하는 클래스 이다. 
 * 
 * 한 인터페이스 에 여러 구현체가 필요할 때 주로 씀. 
 *  
 */

// 상위 인터 페이스
interface Seller {
    public void sell();
}

// 인터페이스 구현체
class CupSeller implements Seller {
    public void sell() {
        System.out.println("컵을 팔아요.");
    }
}

// 인터페이스 구현체
class PhoneSeller implements Seller {
    public void sell() {
        System.out.println("전화기를 팔아요.");
    }
}

// 인터페이스 사용하는 클래스
class Mart {
    private Seller seller;
    public Mart(Seller seller) {
        this.seller = seller;
    }
    public void order(){
        seller.sell();
    }
}

// 메인 클래스
public class C06_strategy {
	public static void main(String[] args) {
        Seller cupSeller = new CupSeller();
        Seller phoneSeller = new PhoneSeller();
        Mart mart1 = new Mart(cupSeller);
        mart1.order();
        Mart mart2 = new Mart(phoneSeller);
        mart2.order();
    }
}
