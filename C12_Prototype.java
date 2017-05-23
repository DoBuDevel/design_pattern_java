package design_pattern;

import java.util.Date;

/*
 * Prototype 
 * 아주 일반적인 원형을 만들어서 그것을 복사한 후 적당히 커스터마이징 해서 씀.
 * 
 * 팩토리 패턴과 조합 해서 쓰는 것이 일반적, Factory 클래스에서 원형을 관리하고, 그 Factory의 create 메쏘드가 호출되면,
 * 원형으로 부터 복사해서 외부로 던져줌, 프로토 타입은 팩토리에서만 관리되고, 외부로 들어나지 않음.
 * colone() 메쏘드가 호출 되어 새로운 객체가 생성되는 시점에서 원형이 어찌 생겼는지 크게 신경쓰지 않음,
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
        Complex com = new Complex("매우 복잡한 정보");
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
