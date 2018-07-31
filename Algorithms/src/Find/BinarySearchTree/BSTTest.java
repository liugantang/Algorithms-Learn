package Find.BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTTest {
    public static void main(String[] args) throws FileNotFoundException {
        BST<String, Integer> bst = new BST();

        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Find/BinarySearchTree/test.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext())
        {
            String key = input.next();
            String value = input.next();
            bst.put(key, Integer.parseInt(value));
        }

        Scanner search = new Scanner(System.in);
        String searchOrder;
        while (!search.equals("end"))
        {
            searchOrder = search.next();
            System.out.println(bst.get(searchOrder));
        }
    }
}
