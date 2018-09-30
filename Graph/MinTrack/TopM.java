package Graph.MinTrack;


import java.util.Scanner;

public class TopM {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        PriorityQueue pq = new PriorityQueue(N);
        while (N > 0)
        {
            pq.insert(input.nextInt(), input.nextDouble());
            N--;
        }

        while (pq.size() > 0)
        {
            System.out.print(pq.delMin() + " ");
        }
    }
}
