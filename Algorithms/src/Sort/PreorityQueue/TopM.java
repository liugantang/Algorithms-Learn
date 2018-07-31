package Sort.PreorityQueue;

import java.util.Scanner;

public class TopM {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        MaxPQ<Integer> pq = new MaxPQ<Integer>(N+1);
        while (N > 0)
        {
            pq.insert(input.nextInt());
            N--;
        }

        while (pq.size() > 0)
        {
            System.out.print(pq.delMax() + " ");
        }
    }
}
