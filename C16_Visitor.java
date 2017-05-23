package design_pattern;

import java.util.ArrayList;
import java.util.List;

/*
 * Visitor 복잡한 구조체 안을 돌아다니면서 어떤일을 해야할 때
 * 
 * 하나의 일이 추가된다고 해서 구조체를 변경하는 것은 무리, 이럴때 visitor 추가
 * 
 */
abstract class Component1 implements Acceptor{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    private String componentName;
    protected List<Component1> children = new ArrayList<Component1>();
    public Component1(String componentName) {
        this.componentName = componentName;
    }
    public String getComponentName() {
        return componentName;
    }
    public abstract void add(Component1 c);
    public List<Component1> getChildren(){
        return children;
    }
}

class Composite1 extends Component1 {
    public Composite1(String componentName) {
        super(componentName);
    }
    @Override
    public void add(Component1 c) {
        children.add(c);
    }
}

class Leaf1 extends Component1{
    public Leaf1(String componentName) {
        super(componentName);
    }
    @Override
    public void add(Component1 c) {
        throw new UnsupportedOperationException();
    }
}
// Visitor를 받아들일 수 있는 구조체  
interface Acceptor {
    void accept(Visitor visitor);
}

// Acceptor를 방문하는 Visitor 
interface Visitor {
    void visit(Acceptor acceptor);
}

// 야동 찾는 YadongFinder 
class YadongFinder implements Visitor {
    private List<String> yadongList = new ArrayList<String>();
    private List<String> currentList = new ArrayList<String>();
    public void visit(Acceptor acceptor) {
        if (acceptor instanceof Composite1) {
            Composite1 composite = (Composite1) acceptor;
            currentList.add(composite.getComponentName());
            List<Component1> children = composite.getChildren();
            for (Component1 component : children) {
                component.accept(this);
            }
            currentList.remove(currentList.size()-1);
        }else  if (acceptor instanceof Leaf1) {
            Leaf1 leaf = (Leaf1) acceptor;
            doSomething(leaf);
        }
    }
    protected void doSomething(Leaf1 leaf){
        if (isYadong(leaf)) {
                String fullPath = getFullPath(leaf);
                yadongList.add(fullPath);
            }
    }
    protected String getFullPath(Leaf1 leaf) {
        StringBuilder fullPath = new StringBuilder();
        for (String element : currentList) {
            fullPath.append(element).append("\\");
        }
        return fullPath.append(leaf.getComponentName()).toString();
    }
    private boolean isYadong(Leaf1 leaf) {
        return leaf.getComponentName().endsWith(".avi");
    }

    public List<String> getYadongList() {
        return yadongList;
    }
}

// 테스트 클래스   

public class C16_Visitor {
    public static void main(String[] args) {
        Composite1 main = createComposite();
        YadongFinder visitor = new YadongFinder();
        visitor.visit(main);
        for (String string : visitor.getYadongList()) {
            System.out.println(string);
        }
    }

    private static Composite1 createComposite() {
        Composite1 main = new Composite1("C:");
        Composite1 sub1 = new Composite1("Program Files");
        Composite1 sub2 = new Composite1("WINDOWS");
        Composite1 sub11 = new Composite1("Pruna");
        Composite1 sub21 = new Composite1("system32");
        Composite1 sub111= new Composite1("Incoming");

        Leaf1 leaf1111 = new Leaf1("강호동 닮은여자-짱이쁨.avi");
        Leaf1 leaf1112 = new Leaf1("EBS야동특강.avi");
        Leaf1 leaf211 = new Leaf1("야메떼-다이조부.avi");
        Leaf1 leaf212 = new Leaf1("이건 야동아님.jpg");
        
        main.add(sub1);
        main.add(sub2);
        sub1.add(sub11);
        sub2.add(sub21);
        sub11.add(sub111);

        sub111.add(leaf1111);
        sub111.add(leaf1112);
        sub21.add(leaf211);
        sub21.add(leaf212);
        return main;
    }
}
