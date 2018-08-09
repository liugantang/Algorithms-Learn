package Find.BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTTest {
    public static void main(String[] args) throws FileNotFoundException {
        BST<Integer, Integer> bst = new BST();

        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Find/BinarySearchTree/test.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext())
        {
            int key = input.nextInt();
            int value = input.nextInt();
            bst.put(key, value);
        }

        Scanner search = new Scanner(System.in);
        int searchOrder = 0;
        while (searchOrder != -1)
        {
            searchOrder = search.nextInt();
            System.out.println(bst.keys());
        }

        System.out.println("Enter rank num");

        searchOrder = 0;
        while (searchOrder != -1)
        {
            searchOrder = search.nextInt();
            System.out.println(bst.rank(searchOrder));
        }
    }
}
