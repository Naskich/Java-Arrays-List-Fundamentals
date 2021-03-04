
/*7.	Append Arrays
Write a program to append several arrays of numbers.
	Arrays are separated by "|"
	Values are separated by spaces (" ", one or several)
	Order the arrays from the last to the first, and their values from left to right

Examples
Input	Output
1 2 3 |4 5 6 |  7  8	7 8 4 5 6 1 2 3
7 | 4  5|1 0| 2 5 |3	3 2 5 1 0 4 5 7
1| 4 5 6 7  |  8 9	8 9 4 5 6 7 1
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        List<String> numbersArr = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
       
        Collections.reverse(numbersArr);
        String numbersPrint = numbersArr.toString().replaceAll("[\\]\\[,]", "").trim();
        numbersPrint = numbersPrint.replaceAll("\\s+", " ");
 
        System.out.println(numbersPrint);
        
    }
}
