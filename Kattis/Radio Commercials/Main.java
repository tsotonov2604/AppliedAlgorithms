import java.util.*;

public class Main
{
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      
        int n,p;
       
      
       //Taking N and P input from user
       n = in.nextInt();
       p = in.nextInt();

        //Declaring an array of size N      
       int[] arr = new int[n];
      
       //Taking array input from user
       for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
       }
      
       //From each break, subtracting cost of that break
       //i.e. Number_of_students - break_cost
       for(int i=0;i<n;i++){
            arr[i] = arr[i] - p;
       }
      
       //Applying Kadane's Algorithm to find maximum sum subarray
       int max_so_far = 0;
       int ans = 0;
       for(int i=0;i<n;i++){
            max_so_far += arr[i];
          
            if(max_so_far < 0)
                max_so_far = 0;
              
            if(ans < max_so_far)
                ans = max_so_far;
       }
      
       //Printing out the results.
    System.out.println(ans);
   }
}