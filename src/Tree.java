import java.util.*;

public class Tree {
    public class MyNodes {
        ArrayList<MyNodes> children;
        int number;
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

    int[] nodes;
    MyNodes rootNode;
    public Tree(int[] nodes) {
        this.nodes = nodes;
    }
    public void calculate_height() {
        int root = 0;
        Stack<MyNodes> toAdd = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                root = i;
                break;
            }
        }
        rootNode = new MyNodes(root);
        toAdd.add(rootNode);
        while (!toAdd.isEmpty()) {
            MyNodes next = toAdd.pop();
            for(int i=0; i < nodes.length; i++) {
                if(nodes[i] == next.getNumber()) {
                    MyNodes child = new MyNodes(i);
                    next.addChildren(child, next);
                    toAdd.add(child);
                }
            }
        }
        depthFirstSearch(rootNode);

    }
    public void depthFirstSearch(MyNodes root) {
        int deepest =1;
        int counter = 1;
        Stack<MyNodes> toSearch = new Stack<>();
        Stack<MyNodes> secondSearch = new Stack<>();
        if(root.getChildren() == null) {
            System.out.println(1);
            return;
        }
        toSearch.add(root);
        secondSearch.add(root);
        while (!toSearch.isEmpty()) {
            MyNodes next = toSearch.pop();
            for (MyNodes node: next.getChildren()
            ) {
                toSearch.add(node);
                secondSearch.add(node);
            }
        }

        while(!secondSearch.isEmpty()) {
            MyNodes next = secondSearch.pop();
            MyNodes theParent;
            try {
                 theParent = next.parent;
            } catch ( NullPointerException e) {
                counter += 1;
                if(deepest < counter) {
                    deepest = counter;
                }
                break;
            }
            while(theParent != root) {
                counter +=1;
                try {
                    theParent = theParent.parent;
                } catch ( NullPointerException e) {
                    break;
                }
            }
            if(deepest < counter) {
                deepest = counter;
                counter = 1;
            }
        }
        System.out.println(deepest);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] all_entries = new String[2];
        int i=0;
        while(i < 2) {
             all_entries[i] = scanner.nextLine();
             i++;
        }
        int size = Integer.parseInt(all_entries[0]);
        String[] line2 = all_entries[1].split(" ");
        int[] nodes = new int[size];
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(line2[i]);
        }
        Tree tree = new Tree(nodes);
        tree.calculate_height();
    }
}
