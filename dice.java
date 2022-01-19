import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class kocky
{
    public static void main(String[] args)
    {
        int numberOfDice = 0;
        int numberOfThrows = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadaj počet kociek:");
        numberOfDice = sc.nextInt();
        System.out.println("Zadaj pocet hodov:");
        numberOfThrows = sc.nextInt();
        int [] res = new int[numberOfThrows];
        for (int i = 0; i < numberOfThrows; i++)
        {
            res[i] = oneThrow(numberOfDice);
        }
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        System.out.println(Arrays.toString(res));
        Arrays.sort(res);
        for (int i = 0; i < numberOfThrows; i++)
        {
            if (i==0) frequency.put(res[i],1);
            else
            if (res[i]==res[i-1])
            {
                frequency.put(res[i],frequency.get(res[i])+1);
            }
            else frequency.put(res[i],1);
        }
        for (int i : frequency.keySet()) {
            System.out.println(i + ".".repeat(frequency.get(i)) +"*"+ frequency.get(i));
        }

    }

    private static int oneThrow(int dice){
        int sum = 0;
        Random rnd = new Random();
        for (int i = 0; i < dice; i++)
        {
            sum+=rnd.nextInt(6)+1;
        }
        return sum;
    }
}
