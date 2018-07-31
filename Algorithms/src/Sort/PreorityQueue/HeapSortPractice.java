package Sort.PreorityQueue;


import java.util.Arrays;

public class HeapSortPractice {
    public static void main(String[] args)
    {
        Comparable[] testNums = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        HeapSort.sort(testNums);
        System.out.println(Arrays.toString(testNums));

//        Random random = new Random(47);
//        Comparable[] randTestNums = new Comparable[1000000];
//        for (int i = 0; i < randTestNums.length; i++)
//        {
//            randTestNums[i] = random.nextInt(1000000);
//        }
//
//        HeapSort.sort(randTestNums);
//        System.out.println(Arrays.toString(randTestNums));
//        System.out.println(ShellSortPractice.checkSort(randTestNums));

     }
}
