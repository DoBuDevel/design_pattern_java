package design_pattern;

/*
 * Chain of Responsibility
 * 
 * �ڽ��� �ذ��� �� �ִ� ������ ������ Ŭ����??!?!
 */

// ������: ���� Ŭ����
abstract class Expert {
    private Expert next;
    protected String expertName;
    public final void support(Problem p){
        if (solve(p)) {
           System.out.println(expertName+ "��(��) " + p.getProblemName()  +"��(��) �ذ��� ���ȳ�.");
        }else{
            if (next != null) {
                next.support(p);
            }else{
                System.out.println(p.getProblemName() + "��(��) �ذ��� ���� ����.");
            }
        }
    }
    public Expert setNext(Expert next){
        this.next = next;
        return next;
    }
    protected abstract boolean solve(Problem p);
}

// ���������� Ǯ����� ���� Ŭ����

class Problem {
    private String problemName;
    public Problem(String name) {
        this.problemName = name;
    }
    public String getProblemName() {
        return problemName;
    }
}

// ù��° ������ ������!

class Fighter extends Expert {
    public Fighter(){
        this.expertName = "������";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("����");
    }
}

// �ι�° ������ ��Ŀ!

class Hacker extends Expert {
    public Hacker(){
        this.expertName = "��Ŀ";        
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("��ǻ��");
    }
}

// ����° ������ ī����!

class Casanova extends Expert {
    public Casanova(){
        expertName = "ī����";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("����") || p.getProblemName().contains("����");
    }
}

// �׽�Ʈ Ŭ����

public class C09_ChainOfResponsiblity {
    public static void main(String[] args) {
        Problem[] problems = new Problem[5];
        problems[0] = new Problem("��ġ ū ����");
        problems[1] = new Problem("��ǻ�� ������ġ");
        problems[2] = new Problem("��ĥ�� ����");
        problems[3] = new Problem("������ ����");
        problems[4] = new Problem("��ź");
        
        Expert fighter = new Fighter();
        Expert hacker = new Hacker();
        Expert casanova = new Casanova();
        
        fighter.setNext(hacker).setNext(casanova);
        
        for (Problem problem : problems) {
            fighter.support(problem);
        }
    }
}
