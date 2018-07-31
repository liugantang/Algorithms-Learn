package Find.ST;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

///home/liugantang/IdeaProjects/Algorithms/src/Find/SequentialSearchST
public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(8);
        Scanner in = new Scanner(System.in);
        int minlen = in.nextInt();
        File file = new File("/home/liugantang/IdeaProjects/Algorithms/src/Find/ST/tale.txt");
        Scanner inFile = new Scanner(file);
        while (inFile.hasNext())
        {
            String word = inFile.next();
            if (word.length() < minlen)
            {
                continue;
            }
            if (!st.contains(word))
            {
                st.put(word, 1);
            }
            else
            {
                st.put(word, st.get(word)+1);
            }

        }

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys(st.select(0), st.select(st.size()-1)))
        {
            int i = st.get(word);
            int j = st.get(max);
            if (i > j)
            {
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));

    }
}
