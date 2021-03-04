
/*1.Train
On the first line you will be given a list of wagons (integers).
Each integer represents the number of passengers that are currently in each wagon.
On the next line you will get the max capacity of each wagon (single integer).
Until you receive "end" you will be given two types of input:
•Add {passengers} - add a wagon to the end with the given number of passengers
•{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
At the end print the final state of the train (all the wagons separated by a space)
Example
Input	Output
32 54 21 12 4 0 23
75
Add 10
Add 0
30
10
75
end	72 54 21 12 4 75 23 10 0
0 0 0 10 2 4
10
Add 10
10
10
10
8
6
end	10 10 10 10 10 10 10
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Train {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        List<Integer> numbersPassengers = Arrays.stream(scanner.nextLine().split("\\s+"))
	                .map(Integer::parseInt).collect(Collectors.toList());
	        int maxCapacity = Integer.parseInt(scanner.nextLine());
	        String commands = scanner.nextLine();
	        while (!commands.equals("end")) {
	            String[] wagonsAdd = commands.split("\\s+");
	            String commandOrNubers = wagonsAdd[0];
	            if (commandOrNubers.equals("Add")) {
	                String numbresPeople = wagonsAdd[1];
	                int numbers = Integer.parseInt(numbresPeople);
	                for (int i = 0; i < numbersPassengers.size() - 1; i++) {
	                    int numbersWagonArr = numbersPassengers.get(i);
	                    if (numbersWagonArr + numbers <= maxCapacity) {
	                        numbersPassengers.add(numbers);
	                        break;
	                    }              
	                }
	            } else {
	                commandOrNubers = wagonsAdd[0];
	                int numbersPeopleWagons = Integer.parseInt(commandOrNubers);
	                int sum = 0;
	                for (int i = 0; i < numbersPassengers.size() - 1; i++) {
	                    int numbersWagonArr = numbersPassengers.get(i);
	                        sum = numbersWagonArr + numbersPeopleWagons;
	                    if (sum <= maxCapacity) {                
	                        numbersPassengers.set(i,sum);
	                        break;
	                    }   
	                }
	            }
	            commands = scanner.nextLine();
	        }
	        printWagonsPeople(numbersPassengers);
	    }
	    public static void printWagonsPeople(List <Integer>numbersPassengers) {
	        for(int number :numbersPassengers){
	            System.out.print(number + " ");
	        }
	    }
	}

