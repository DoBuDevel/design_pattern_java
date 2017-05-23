package design_pattern;

import java.util.Observable;
import java.util.Observer;

/*
 * Observe 패턴
 * 
 * 어떤 클래스에 변화가 일어났을 때, 다른 클래스에 통보해 주는 패턴
 * 
 * setChanged - 변화가 일어났을 때 알려줌
 * notifyObservers() - observer 들에게 전부 알림
 *
 */
// 변화를 통보하는 Observable
class Watcher extends Observable {
    public void action(String string) {
        System.out.println("======="+string+"========");
        setChanged();
        notifyObservers(string); 
    }
}

// 변화를 통보받는 직원 
class Employee implements Observer {
    private String desc;
    public Employee(String desc) {
        this.desc = desc;
    }
    public void update(Observable o, Object arg) {
        if (o instanceof Watcher) {
            System.out.println(desc + "이 일하는 척");
        }
    }
    public String getDesc() {
        return desc;
    }
}

// 변화를 통보받는 사장 끄나풀
class Spy implements Observer {
    private Employee employee;
    public Spy(Employee employee) {
        this.employee = employee;
    }
    public void update(Observable o, Object arg) {
        if (o instanceof Watcher) {
            System.out.println("고자질쟁이가 "+employee.getDesc() +"이 놀고 있었다고 고자질.");
        }
    }
}

// 테스트 클래스 
public class C11_Observer {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        Employee pc1 = new Employee("만화책보는 놈");
        Employee pc2 = new Employee("퍼질러 자는 놈");
        Employee pc3 = new Employee("포카치는 놈");
        //spy는 pc3을 보고 있음.
        //요놈은 꼰질르기의 대가
        Spy spy = new Spy(pc3);
        
        watcher.addObserver(pc1);
        watcher.addObserver(pc2);
        watcher.addObserver(pc3);
        watcher.addObserver(spy);
        
        watcher.action("사장 뜸1.");
        watcher.deleteObserver(pc3);
        watcher.deleteObserver(spy);
        
        watcher.action("사장 뜸2.");
    }
}
