import java.util.*;

public class Tree {
    int[] nodes;
    MyNodes rootNode;
    public Tree(int[] nodes) {
        this.nodes = nodes;
    }

//    public ArrayList<Integer> addChildren(int number) {
//        ArrayList<Integer> allChildren = new ArrayList<>();
//        for (int i=0; i<nodes.length; i++) {
//            if(nodes[i] == number) {
//                allChildren.add(nodes[i]);
//            }
//        }
//        return allChildren;
//    }

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
            System.out.println("The next node is" + next.getNumber());
            for(int i=0; i < nodes.length; i++) {
                if(nodes[i] == next.getNumber()) {
                    MyNodes child = new MyNodes(i);
                    next.addChildren(child);
                    toAdd.add(child);
                    System.out.println(next.getNumber() + " has a new child +" + child.getNumber());
                }
            }
        }
    }
    public void depthFirstSearch() {

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String tree_size = scanner.next();
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
