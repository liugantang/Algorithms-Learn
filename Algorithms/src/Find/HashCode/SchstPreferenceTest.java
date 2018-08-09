package Find.HashCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SchstPreferenceTest {
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        SeparateChainingHashST st = new SeparateChainingHashST(997);
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Find/HashCode/tale.txt");
        Scanner input = new Scanner(file);
        while (input.hasNext())
        {
            String s = input.next();
            if (s != null)
            {
                st.put(s, i);

            }
            i++;
        }

        System.out.println(st.keys());
    }
}
