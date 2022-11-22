import java.util.*; 
import java.io.*;

class Main {

  public static int BracketCombinations(int num) {
    return catalanNumber(num);
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(BracketCombinations(s.nextLine())); 
  }


  public static int catalanNumber(int num) {
      return (fact(2 * num)) / (fact(num + 1) * fact(num));
  }

  public static int fact(int i) {
      if (i <= 1) {
          return 1;
      }
      return i * fact(i - 1);
  }

}
