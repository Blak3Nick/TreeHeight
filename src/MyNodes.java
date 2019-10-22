import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyNodes {
    ArrayList<MyNodes> children;
    int number;
    boolean visited = false;
    public MyNodes(int number) {
        this.children = new ArrayList<>();
        this.number = number;
    }
    public void addChildren(MyNodes node) {
        children.add(node);
    }
    public ArrayList<MyNodes> getChildren() {
        if(children.isEmpty()) {
            return null;
        }
        return children;
    }
    public int getNumber() {
        return number;
    }

    public void depthFirstSearch(MyNodes root) {
        int deepest =1;
        int numChildren;
        Queue<MyNodes> toSearch = new LinkedList<>();
        if(root.getChildren() == null) {
            System.out.println(1);
            return;
        }
        toSearch.add(root);
        while (!toSearch.isEmpty()) {
            MyNodes cur = toSearch.remove();
            numChildren = cur.getChildren().size();
            for (MyNodes node : cur.getChildren()
                 ) {
                toSearch.add(node);
            }


        }

    }



}
