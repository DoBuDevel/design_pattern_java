package design_pattern;

/*
 * Mediator
 * ����� ������ ����� ��θ� ���̰� �ܼ�ȭ�� -(������ ����ž�ϰ� ��Ÿ��� , ����Ⳣ�� ������� ����, �׷��� �δ�ġ�� ����)
 */

// ����ž ������ �ϴ� ControlTower (Ȱ�ַ� ���ҵ� ��) 
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
        System.out.println(seq +"�� ����� ���� ����");
        Thread.sleep(50L);
        System.out.println(seq + "�� ����� ���� ��");
        inUse = false;
    }
}
// �����㰡�� �޾ƾ��ϴ� Airplane 

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
                //System.out.println(seq +"�� ° ����� ��� ��.");
                Thread.sleep(10L);
            }
            tower.land(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// �׽�Ʈ Ŭ����  

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
