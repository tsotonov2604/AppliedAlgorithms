import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int tests = scanner.nextInt();

    for (int i = 0; i < tests; i++)
        {

        ArrayList<Integer> results = new ArrayList<>();
        int customer = scanner.nextInt();
        
        for (int c = 0; c < customer; c++)
            {
            int woodCount = scanner.nextInt();
            int woodTotal = 0;
            
            for (int j = 0; j < woodCount; j++)
                woodTotal += scanner.nextInt();
            
            results.add(woodTotal);
            }
        
        Collections.sort(results);
        
        long finalSum = 0;
        int sum = 0;
        
        for (int k = 0; k < results.size(); k++)
            {
            sum += results.get(k);
            finalSum += sum;
            }
        
        double minAverage = finalSum / ((double)results.size());
        
        System.out.printf("%.7f" , minAverage);
        System.out.println();

        }

    scanner.close();
        }
}