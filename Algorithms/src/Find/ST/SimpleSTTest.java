package Find.ST;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SimpleSTTest {
    public static void main(String[] args)
    {
        ST<String, Integer> st;
        st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++)
        {
            String t = StdIn.readString();
            if (t.equals("end"))
            {
                break;
            }
            String key = t;
            st.put(key, i);
        }

        for (String s : st.keys())
        {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
