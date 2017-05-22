package design_pattern;

/*
 * Template ����
 * - �������� ������ ���� Ŭ���� (�ַ� abstract ���� ����).
 * - ��ü�� ������ ���� Ŭ����
 */

abstract class Worker {
    protected abstract void doit();
    public final void work(){
        System.out.println("���");
        doit();
        System.out.println("���");
    }
}

class Designer extends Worker {
    @Override
    protected void doit() {
        System.out.println("������ ������");
    }
}

class Gamer extends Worker {
    @Override
    protected void doit(){
        System.out.println("������ ����");
    }
}

public class C04_Template_method {
	public static void main(String[] args) {
        Worker designer = new Designer();
        designer.work();
        Worker gamer = new Gamer();
        gamer.work();
    }
}
