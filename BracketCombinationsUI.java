import java.util.*; 
import java.io.*;

class Main {

    private final static String PARENTHESIS_OPEN = "(";
    private final static String PARENTHESIS_CLOSE = ")";

    public static int BracketCombinations(int num) {
        ArrayList<String> combinations = new ArrayList<>();
        createParenthesis(num, 0, 0, "", combinations);
        return combinations.size();
    }

    public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(s.nextLine())); 
    }

    public static void createParenthesis(int num, int openCount, int closeCount,
                                         String posible, ArrayList<String> combinations) {

        if (validParenthesis(posible, num)) {
            combinations.add(posible);
            return;
        }

        if (openCount < num) {
            createParenthesis(num, openCount + 1, closeCount, posible + PARENTHESIS_OPEN, combinations);
        }

        if (closeCount < openCount) {
            createParenthesis(num, openCount, closeCount + 1, posible + PARENTHESIS_CLOSE, combinations);
        }

    }

    public static boolean validParenthesis(String result, int num) {
        if (result.split("").length != num * 2) {
            return false;
        }

        int balance = 0;
        for (String c : result.split("")) {
            if (Objects.equals(c, PARENTHESIS_OPEN)) {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }


}
