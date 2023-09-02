import java.util.Random;
import java.util.Scanner;
 
public class Permute_All_List_Numbers 
{
    static void permute(int[] a, int k) 
    {
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
 
    public static void main(String args[]) 
    {
        Random random = new Random();
    
     
        int N =10;
        int[] sequence = new int[N];
 
        for (int i = 0; i < N; i++)
            sequence[i] = i;
 
        System.out.println("The original sequence is: ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
 
        System.out.println("\nThe permuted sequences are: ");
        permute(sequence, 0);
 
    
    }
}