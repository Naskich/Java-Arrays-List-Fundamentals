
/**3.	House Party
Write a program that keeps track of the guests that are going to a house party.
On the first input line you are going to receive how many commands you are going to have.
 On the next lines you are going to receive some of the following inputs:
-	"{name} is going!"
-	"{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not in the list.
 (If he/she is in the list print on the console: "{name} is already in the list!").
  If you receive the second type of input, you have to remove the person if he/she is in the list.
   (If not print: "{name} is not in the list!"). At the end print all guests.
Examples
Input	Output
4
Allie is going!
George is going!
John is not going!
George is not going!	John is not in the list!
Allie
5
Tom is going!
Annie is going!
Tom is going!
Garry is going!
Jerry is going!	Tom is already in the list!
Tom
Annie
Garry
Jerry
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class HouseParty {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
     int numbersGuest = Integer.parseInt(scanner.nextLine());    
     List<String> names = new ArrayList<>(); 
     int count = 0;
     while (numbersGuest>count) {
    	 String name = scanner.nextLine();
    	 String [] namesGuest = name.split("\\s+");
    	 
    	 String namesGoingNot = namesGuest[0];
    	 	if (namesGuest[2].equals("going!")) {
    	 		if (names.contains(namesGoingNot)) {
					System.out.printf("%s is already in the list!%n",namesGoingNot);
				} else {
					names.add(namesGoingNot);
				}
    	 	} else if (namesGuest[2].equals("not")) {
				if (names.contains(namesGoingNot)) {
					names.remove(namesGoingNot);
				} else {
					System.out.printf("%s is not in the list!%n",namesGoingNot);
				} 	 	   	 		
			}
    	 count++;
     	}
     namePrint(names);
	}	
    public static void namePrint(List <String> names) {
    	 for(String name :names){         
                 System.out.println(name);           
    	 }
    }
}