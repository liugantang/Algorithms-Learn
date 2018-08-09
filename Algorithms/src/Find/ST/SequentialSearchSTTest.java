package Find.ST;

import java.util.Scanner;

public class SequentialSearchSTTest {
    public static void main(String[] args)
    {
        int i = 0;
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        Scanner input = new Scanner(System.in);
        while (input.hasNext())
        {

            String s = input.next();
            if (s.equals("end"))
            {
                break;
            }
            st.put(s, i);
            i++;
        }

        System.out.println(st.keys());

    }
}
