
/*Write a program, which reads a list of integers from the console and receives commands,
 *  which manipulate the list. Your program may receive the following commands: 
•	Delete {element} - delete all elements in the array, which are equal to the given element
•	Insert {element} {position} - insert element at the given position
You should stop the program when you receive the command "end".
 Print all numbers in the array separated with a single whitespace.
Examples
Input	Output
1 2 3 4 5 5 5 6
Delete 5
Insert 10 1
Delete 5
end	1 10 2 3 4 6
20 12 4 319 21 31234 2 41 23 4
Insert 50 2
Insert 50 5
Delete 4
end	20 12 50 319 50 21 31234 2 41 23
 * */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class ChangeList {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("end")){
        	String input = commands.split("\\s+")[0];  
          int numbersInsertDel = Integer.parseInt(commands.split("\\s+")[1]);
          if (input.equals("Delete")){
        	  numbers.removeAll(Arrays.asList(numbersInsertDel));
          } else if (input.equals("Insert")){
        	  int numberIndex = Integer.parseInt(commands.split("\\s+")[2]);
              numbers.add(numberIndex, numbersInsertDel);                           
          }
            commands = scanner.nextLine();
        }
        printElementsList(numbers);
    }
    public static void printElementsList(List<Integer>numbers){
        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }
}
