import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        // TODO: Fill in this function.
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++){
            dice[i] = i + 1;
        }
        return dice;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        String[] result;
        if (Objects.equals(customer,"Ergun")){
            result = new String[] {"beyti","pizza", "hamburger", "tea"};
        }
        else if (Objects.equals(customer, "Erik")){
            result = new String[] {"sushi", "pasta", "avocado", "coffee"};
        }
        else{
            result = new String[3];
        }
        return result;
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int min_array = array[0];
        int max_array = array[0];
        int i = 0;
        while(i < array.length) {
            if (array[i] < min_array) {
                min_array = array[i];
            }
            if (array[i] > max_array) {
                max_array = array[i];
            }
            i++;
        }
        return max_array - min_array;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        return hailstoneHelper(n, list);
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        if (x == 1) {
            return list;
        }
        if (x % 2 == 0){
            x = x / 2;
        }
        else {
            x = x * 3 + 1;
        }
        list.add(x);
        return hailstoneHelper(x, list);
    }
}
