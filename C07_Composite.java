package design_pattern;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite 패턴
 * 파일 데이터와 같은 일반적인 트리구조의 데이터 타입을 만드는 것이 Composite 패턴입니다.
 * 
 * 구성요소
 * 1. 상위 컴포넌트
 * 2. 컴포넌트를 상속 받으며 자식 컴포넌트를 가질 수 있는 Composite
 * 3. 상위 컴포넌트를 상속 받으며 하위 컴포넌트를 가질 수 없는 Leaf.(디렉토리 - Composite, 파일 - Leaf )
 */

abstract class Component {
    private String componentName;
    protected List<Component> children = new ArrayList<Component>();
    public Component(String componentName) {
        this.componentName = componentName;
    }
    public String getComponentName() {
        return componentName;
    }
    public abstract void add(Component c);
    public List<Component> getChildren(){
        return children;
    }
    public String getString(){
        return getString(0);
    }
    private String getString(int depth){
        StringBuffer sb = new StringBuffer();
        if (this instanceof Composite) {
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append("+"+getComponentName() +"\n");
            for (Component comp: children) {
                sb.append(comp.getString(depth+1));
            }
        }else{
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append("-"+getComponentName()+"\n");
        }
        return sb.toString();  
    }
}


//----------------- 하위 Composite(하위 노드 가질 수 있음) ----------------- 
class Composite extends Component {
    public Composite(String componentName) {
        super(componentName);
    }
    @Override
    public void add(Component c) {
        children.add(c);
    }
}

//----------------- 하위 Leaf(하위 노드 가질 수 없음) ----------------- 
class Leaf extends Component{
    public Leaf(String componentName) {
        super(componentName);
    }
    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException();
    }
}

//----------------- 테스트 클래스 ----------------- 

public class C07_Composite {
    public static void main(String[] args) {
        Composite main = new Composite("Main");
        Composite sub1 = new Composite("sub1");
        Composite sub2 = new Composite("sub2");
        Composite sub11 = new Composite("sub11");
        Composite sub12 = new Composite("sub12");
        Composite sub13 = new Composite("sub13");
        Composite sub21 = new Composite("sub21");
        Composite sub22 = new Composite("sub22");
        Leaf leaf14 = new Leaf("leaf14");
        Leaf leaf121 = new Leaf("leaf121");
        
        main.add(sub1);
        main.add(sub2);
        sub1.add(sub11);
        sub1.add(sub12);
        sub1.add(sub13);
        sub2.add(sub21);
        sub2.add(sub22);
        sub1.add(leaf14);
        sub12.add(leaf121);
        
        System.out.println(main.getString());
    }
}

