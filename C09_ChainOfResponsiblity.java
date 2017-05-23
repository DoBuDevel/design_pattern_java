package design_pattern;

/*
 * Chain of Responsibility
 * 
 * 자신이 해결할 수 있는 문제를 나열한 클래스??!?!
 */

// 전문가: 상위 클래스
abstract class Expert {
    private Expert next;
    protected String expertName;
    public final void support(Problem p){
        if (solve(p)) {
           System.out.println(expertName+ "이(가) " + p.getProblemName()  +"을(를) 해결해 버렸네.");
        }else{
            if (next != null) {
                next.support(p);
            }else{
                System.out.println(p.getProblemName() + "은(는) 해결할 넘이 없다.");
            }
        }
    }
    public Expert setNext(Expert next){
        this.next = next;
        return next;
    }
    protected abstract boolean solve(Problem p);
}

// 전문가들이 풀어야할 문제 클래스

class Problem {
    private String problemName;
    public Problem(String name) {
        this.problemName = name;
    }
    public String getProblemName() {
        return problemName;
    }
}

// 첫번째 전문가 파이터!

class Fighter extends Expert {
    public Fighter(){
        this.expertName = "격투가";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("깡패");
    }
}

// 두번째 전문가 해커!

class Hacker extends Expert {
    public Hacker(){
        this.expertName = "해커";        
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("컴퓨터");
    }
}

// 세번째 전문가 카사노바!

class Casanova extends Expert {
    public Casanova(){
        expertName = "카사노바";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("여자") || p.getProblemName().contains("여성");
    }
}

// 테스트 클래스

public class C09_ChainOfResponsiblity {
    public static void main(String[] args) {
        Problem[] problems = new Problem[5];
        problems[0] = new Problem("덩치 큰 깡패");
        problems[1] = new Problem("컴퓨터 보안장치");
        problems[2] = new Problem("까칠한 여자");
        problems[3] = new Problem("날렵한 깡패");
        problems[4] = new Problem("폭탄");
        
        Expert fighter = new Fighter();
        Expert hacker = new Hacker();
        Expert casanova = new Casanova();
        
        fighter.setNext(hacker).setNext(casanova);
        
        for (Problem problem : problems) {
            fighter.support(problem);
        }
    }
}
