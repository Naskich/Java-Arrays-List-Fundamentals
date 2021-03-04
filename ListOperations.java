

/*4.	List Operations
You will be given numbers (list of integers) on the first input line. Until you receive
 "End" you will be given operations you have to apply on the list. The possible commands are:
•	Add {number} - add number at the end
•	Insert {number} {index} - insert number at given index
•	Remove {index} - remove that index
•	Shift left {count} - first number becomes last 'count' times
•	Shift right {count} - last number becomes first 'count' times
Note: It is possible that the index given is outside of the bounds of the array. In that case print "Invalid index".
Examples
Input	Output
1 23 29 18 43 21 20 
Add 5
Remove 5
Shift left 3
Shift left 1
End	43 20 5 1 23 29 18
5 12 42 95 32 1
Insert  3 0
Remove 10
Insert 8 6
Shift right 1
Shift left 2
End	Invalid index
5 12 42 95 32 8 1 3
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[] input = commands.split("\\s+");            
            String command = input[0];
            if (command.equals("Add")) {
                int numberAdd = Integer.parseInt(input[1]);
                numbers.add(numberAdd);
            } else if (command.equals("Insert")) {
                int numberAdd = Integer.parseInt(input[1]);
                int numberIndex = Integer.parseInt(input[2]);
                if (isValiedIndex(numberIndex, numbers.size())) {
                    numbers.add(numberIndex, numberAdd);
                } else {
                    System.out.print("Invalid index\n");
                }
            } else if (command.equals("Remove")) {
                int indexRemove = Integer.parseInt(input[1]);
                if (isValiedIndex(indexRemove, numbers.size())) {
                    numbers.remove(indexRemove);
                } else {
                    System.out.print("Invalid index\n");
                }
            } else if (command.equals("Shift")) {
                String leftRightString = input[1];
                int count = Integer.parseInt(input[2]);
                if (leftRightString.equals("left")){
                    for (int i = 0; i <= count; i++) {
                        int firstNumber = numbers.get(0);
                        numbers.remove(0);
                        numbers.add(firstNumber);
                    }
                } else if (leftRightString.equals("right")){
                    for (int i = numbers.size()-1; i >= count; i--) {
                        int lastNumbers = numbers.get(numbers.size()-1);
                        numbers.remove(numbers.size()-1);
                        numbers.add(0,lastNumbers);
                    }
                }
                break;
            }
            commands = scanner.nextLine();
        }
        printListArr(numbers);
    }
    private static boolean isValiedIndex(int indexRemove,int lenght) {
        return   indexRemove>=0 && indexRemove<=lenght-1;
    }
    public static void printListArr(List<Integer>numbers){
        for(int number :numbers){
            System.out.print(number + " ");
        }
    }
}