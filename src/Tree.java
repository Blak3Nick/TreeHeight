import java.util.Arrays;
import java.util.Scanner;

public class Tree {

    public void calculate_height(int[] nodes) {
        int depth_counter = 1;
        int root = 0;
        for(int i =0; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                root = i;
                break;
            }
        }


    }

    public static void main(String[] args) {
        Tree tree = new Tree();
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


    }
}
