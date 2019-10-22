import java.util.*;

public class MyNodes {
    ArrayList<MyNodes> children;
    int number;
    boolean visited = false;
    MyNodes parent;
    public MyNodes(int number) {
        this.children = new ArrayList<>();
        this.number = number;
    }
    public void addChildren(MyNodes node, MyNodes parent) {
        node.parent = parent;
        children.add(node);
    }
    public ArrayList<MyNodes> getChildren() {
        if(children.isEmpty()) {
            return new ArrayList<>();
        }
        return children;
    }
    public int getNumber() {
        return number;
    }

}
