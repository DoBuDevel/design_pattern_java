package design_pattern;

/*
 * Mediator
 * 통신을 집중해 통신의 경로를 줄이고 단순화함 -(비행기는 관제탑하고 통신만함 , 비행기끼리 통신하지 않음, 그런데 부닥치진 않음)
 */

// 관제탑 역할을 하는 ControlTower (활주로 역할도 함) 
class ControlTower {
    private volatile  boolean inUse;
    
    public synchronized boolean getPermission(){
        if (inUse) {
            return false;
        }else{
            inUse = true;
            return true;
        }
    }
    
    public void land(Airplane airplane) throws InterruptedException{
        int seq = airplane.getSeq();
        System.out.println(seq +"번 비행기 착륙 시작");
        Thread.sleep(50L);
        System.out.println(seq + "번 비행기 착륙 끝");
        inUse = false;
    }
}
// 착륙허가를 받아야하는 Airplane 

class Airplane extends Thread {
    private final ControlTower tower;
    private final int seq;

    public Airplane(ControlTower tower, int seq) {
        this.tower = tower;
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    @Override
    public void run() {
        try {
            while (!tower.getPermission()) {
                //System.out.println(seq +"번 째 비행기 대기 중.");
                Thread.sleep(10L);
            }
            tower.land(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 테스트 클래스  

public class C15_Mediator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Airplane[] airplanes = new Airplane[10];
        for (int i = 0; i < airplanes.length; i++) {
            airplanes[i] = new Airplane(tower, i);
        }
        for (Airplane airplane : airplanes) {
            airplane.start();
        }
    }
}
