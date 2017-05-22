package design_pattern;

/*
 * Template 패턴
 * - 전반적인 구현은 상위 클래스 (주로 abstract 에서 만듬).
 * - 구체적 구현은 하위 클래스
 */

abstract class Worker {
    protected abstract void doit();
    public final void work(){
        System.out.println("출근");
        doit();
        System.out.println("퇴근");
    }
}

class Designer extends Worker {
    @Override
    protected void doit() {
        System.out.println("열심히 디자인");
    }
}

class Gamer extends Worker {
    @Override
    protected void doit(){
        System.out.println("열심히 껨질");
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
