package corejava;
 
import java.util.Arrays;
import java.util.List;
 
public class CatchyNumberFinder {
	
    public static String findCatchyNumber(List<String> numbers) {
        String catchyNumber = null;
        int maxCatchiness = Integer.MIN_VALUE;
        for (String number : numbers) {
            int catchiness = calculateCatchiness(number);
            if (catchiness > maxCatchiness) {
                maxCatchiness = catchiness;
                catchyNumber = number;
            }
        }
        return catchyNumber;
    }
    public static int calculateCatchiness(String number) {
        int catchiness = 0;
        char[] chars = number.toCharArray();
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                catchiness = Math.max(catchiness, count);
            } else {
                count = 1;
            }
        }
//System.out.println(number +" hello" +catchiness);
        return catchiness;
    }
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("7777", "6666456","11112222");
        String catchyNumber = findCatchyNumber(numbers);
        System.out.println("Most catchy number: " + catchyNumber);
    }
}