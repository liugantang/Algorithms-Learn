package Find.HashCode;

import java.util.Scanner;

public class LBHTest {
    public static void main(String[] args)
    {
        int i = 0;
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();
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
