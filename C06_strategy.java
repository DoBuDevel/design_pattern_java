package design_pattern;

/*
 * Strategy ����
 * 
 * Templete - ����� �� �̿��ؼ� ���� , <-> Strategy ����  ������ �̿�.
 * 
 * Templete ����Ŭ�������� �ٲ�� �κ��� ó�� <-> Strategy �� �ٲ�� �κ��� �������̽��� �и��Ͽ� ó��, �������̽��� ����ü�� �ٲ����μ� ���� ����
 * 
 * Templete ������ �ִ� ���� Ŭ���� ������, Strategy ������ �������̽��� ����ϴ� Ŭ���� �̴�. 
 * 
 * �� �������̽� �� ���� ����ü�� �ʿ��� �� �ַ� ��. 
 *  
 */

// ���� ���� ���̽�
interface Seller {
    public void sell();
}

// �������̽� ����ü
class CupSeller implements Seller {
    public void sell() {
        System.out.println("���� �Ⱦƿ�.");
    }
}

// �������̽� ����ü
class PhoneSeller implements Seller {
    public void sell() {
        System.out.println("��ȭ�⸦ �Ⱦƿ�.");
    }
}

// �������̽� ����ϴ� Ŭ����
class Mart {
    private Seller seller;
    public Mart(Seller seller) {
        this.seller = seller;
    }
    public void order(){
        seller.sell();
    }
}

// ���� Ŭ����
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
