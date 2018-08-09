package Find.HashCode;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SCHSTTest {
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(7);
        Scanner input = new Scanner(System.in);

        String s = input.next();
        while (!s.equals("end"))
        {
            st.put(s, i);
            i++;
            s = input.next();
        }

        System.out.println(st.keys());
        System.out.println(st.get("you"));


    }
}
