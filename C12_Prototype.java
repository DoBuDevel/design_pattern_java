package design_pattern;

import java.util.Date;

/*
 * Prototype 
 * ���� �Ϲ����� ������ ���� �װ��� ������ �� ������ Ŀ���͸���¡ �ؼ� ��.
 * 
 * ���丮 ���ϰ� ���� �ؼ� ���� ���� �Ϲ���, Factory Ŭ�������� ������ �����ϰ�, �� Factory�� create �޽�尡 ȣ��Ǹ�,
 * �������� ���� �����ؼ� �ܺη� ������, ������ Ÿ���� ���丮������ �����ǰ�, �ܺη� ���� ����.
 * colone() �޽�尡 ȣ�� �Ǿ� ���ο� ��ü�� �����Ǵ� �������� ������ ���� ������� ũ�� �Ű澲�� ����,
 */

class Complex implements Cloneable{
    private String complexInfo;

    private Date date;

    public Complex(String complexInfo) {
        this.complexInfo = complexInfo;
    }
    public String getComplexInfo() {
        return complexInfo;
    }
    public void setDate(Date date){
        this.date = new Date(date.getTime());
    }
    public Date getDate() {
        return date;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Complex tmp = (Complex) super.clone();
        return tmp;
    }
}

public class C12_Prototype {
    public static void main(String[] args) {
        Complex com = new Complex("�ſ� ������ ����");
        try {
            Complex cloned1 = (Complex)com.clone();
            cloned1.setDate(new Date(2008,0,1));

            Complex cloned2 = (Complex)com.clone();
            cloned2.setDate(new Date(2008,2,1));
            
            System.out.println(cloned1.getDate());
            System.out.println(cloned2.getDate());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
