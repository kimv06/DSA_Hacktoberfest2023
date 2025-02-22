import java.io.*;  
import java.util.Scanner;    
class WaterJugProblemExample {  
    
    public static int getGCD(int x, int y) {  
        if (y == 0) {  
            return x;  
        }  
          
        return getGCD(y, x % y);  
    }  
  
  public static int pourWater(int fromCapacity, int toCapacity, int d) {  
      
    
        int fromCap = fromCapacity;  
        int toCap = 0;  
  
          
        int reqStep = 1;  
  
                while (fromCap != d && toCap != d) {  
           
            int maxPaur = Math.min(fromCap, toCapacity - toCap);  
    
            toCap = toCap + maxPaur;  
            fromCap = fromCap - maxPaur;  
  
            // increment the value of reqStep  
            reqStep++;  
              
            // check whether "fromCap" or "toCap" has d liters of water  
            if (fromCap == d || toCap == d)  
                break;  
  
            // We fill the first jug when it becomes empty  
            if (fromCap == 0) {  
                fromCap = fromCapacity;  
                reqStep++;  
            }  
  
            // we empty the second jug when it becomes full  
            if (toCap == toCapacity) {  
                toCap = 0;  
                reqStep++;  
            }  
        }  
        // return total number of required steps  
        return reqStep;  
    }  
  
    // create findMisSteps() method that will returns minimum steps needed for messuring d liter  
    public static int findMinSteps(int i, int j, int d) {  
      
        if (i > j) {   
            int temp = i;  
            i = j;  
            j = i;  
        }  
  
        // we can't measure the water using the jugs if d > n  
        if (d > j) {  
            return -1;  // we return -1 in this case  
        }  
        // We cannot solve the water jug problem when gcd of j and i is not possible to divide by d  
        if ((d % getGCD(j, i)) != 0)  
            return -1;  // we return -1 in this case  
  
        // if the above two conditions are not matched, it return following two cases:  
        // x) Water of j liter jug is poured into i liter jug  
        // y) Vice versa of "x"  
        return Math.min(pourWater(j, i, d), // j to i  
                pourWater(i, j, d)); // i to j  
    }  
  
    // main() method  
    public static void main(String[] args) {  
          
        // initialize variables for the size of jugs and amount of water which we want to measure  
        int i, j, d;  
          
        // create Scanner class object to take input from user  
        Scanner sc = new Scanner(System.in);  
          
        System.out.println("Enter the size of Jug1 in liters");  
        i = sc.nextInt();  
          
        System.out.println("Enter the size of Jug2 in liters");  
        j = sc.nextInt();  
          
        System.out.println("Enter the amount of water which you want to messure:");  
        d = sc.nextInt();  
          
        // close Scanner class object  
        sc.close();  
          
        System.out.println("Minimum number of steps required to messure water is " + findMinSteps(i, j, d));  
    }  
}
