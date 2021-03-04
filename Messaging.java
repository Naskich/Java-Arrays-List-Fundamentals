
/*1.	Messaging
You will be given some list of numbers and a string.
 For each element of the list you have to take the sum 
 of its digits and take the element corresponding to that
 index from the text. If the index is greater than the
 length of the text, start counting from the beginning
 (so that you always have a valid index).
 After getting the element from the text,
 you have to remove the character you have
 taken from it (so for the next index, the text will be with one character less).
Example
Input	Output
9992 562 8933
This is some message for you	hey
 * */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {

	public static void main(String[]args) {
		  Scanner scanner = new Scanner(System.in);
	        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
	        String messageInput = scanner.nextLine();
	        StringBuilder message = new StringBuilder();
	        for (int i = 0; i < messageInput.length(); i++) {
	            message.append(messageInput.charAt(i));
	        }
	        for (int i = 0; i < numbers.size(); i++) {
	            int number = numbers.get(i);
	            int sumOfDigits = getSumOfDigits(number);
	            char currCharacter;
	            if (sumOfDigits > message.length() - 1) {
	                sumOfDigits -= message.length();
	            }
	            currCharacter = message.charAt(sumOfDigits);
	            System.out.print(currCharacter);
	            message.deleteCharAt(sumOfDigits);
	        }
	    }
	    private static int getSumOfDigits(int number) {
	        int sum = 0;
	        while (number > 0) {
	            int currDigit = number % 10;
	            sum += currDigit;
	            number /= 10;
	        }
	        return sum;
	    }
	}