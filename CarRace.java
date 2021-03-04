
/*2.	Car Race
Write a program to calculate the winner of a car race.
You will receive an array of numbers. Each element of 
the array represents the time needed to pass through that step (the index).
There are going to be two cars. One of them starts from the left side and the
other one starts from the right side. The middle index of the array is the
finish line. (The number of elements of the array will always be odd).
Calculate the total time for each racer to reach the finish (the middle of the array)
and print the winner with his total time. (The racer with less time).
If you have a zero in the array, you have to reduce the time of the
racer that reached it by 20% (from the time so far).
Print the result in the following format "The winner is {left/right}
 with total time: {total time}", formatted with one digit after the decimal point.
Example
Input	Output
29 13 9 0 13 0 21 0 14 82 12	The winner is left with total time: 53.8
Comment
The time of the left racer is (29 + 13 + 9) * 0.8 (because of the zero) + 13 = 53.8
The time of the right racer is (82 + 12 + 14) * 0.8 + 21 = 107.4
The winner is the left racer, so we print it
 * */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class CarRace {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 List<Integer> numbersTime = Arrays.stream(scanner.nextLine().split("\\s+"))
	                .map(Integer::parseInt).collect(Collectors.toList());
	        double raceSumLeft = 0;
	        double raceSumRight = 0;
	        int sumIndex = 0;
	        int conutZero = 0;
	        if (numbersTime.size()%2==0) {
	            sumIndex = numbersTime.size()/2;
	            for (int i = 0; i <= numbersTime.size()-sumIndex; i++) {
	                if (numbersTime.get(i)==0) {
	                    conutZero+=1;
	                } else {
	                    raceSumLeft+=numbersTime.get(i);
	                }
	                if (conutZero>0){
	                    raceSumLeft=raceSumLeft-(raceSumLeft*0.2);
	                    conutZero=0;
	                }
	            }
	            for (int i = numbersTime.size()-1; i >= numbersTime.size()-sumIndex; i--) {
	                if (numbersTime.get(i)==0) {
	                    conutZero+=1;
	                } else {
	                    raceSumRight+=numbersTime.get(i);
	                }
	                if (conutZero>0){
	                    raceSumRight=raceSumRight-(raceSumRight*0.2);
	                    conutZero=0;
	                }
	            }
	        } else {
	            sumIndex =(numbersTime.size()-1)/2;

	            for (int i = 0; i < numbersTime.size()-1-sumIndex; i++) {
	                if (numbersTime.get(i)==0) {
	                    conutZero+=1;
	                } else {
	                    raceSumLeft+=numbersTime.get(i);
	                }
	                if (conutZero>0){
	                    raceSumLeft=raceSumLeft-(raceSumLeft*0.2);
	                    conutZero = 0;
	                }
	            }
	            for (int i = numbersTime.size()-1; i >= numbersTime.size()-sumIndex; i--) {
	                if (numbersTime.get(i)==0) {
	                    conutZero+=1;
	                } else {
	                    raceSumRight+=numbersTime.get(i);
	                }
	                if (conutZero>0){
	                    raceSumRight=raceSumRight-(raceSumRight*0.2);
	                    conutZero=0;
	                }
	            }
	        }
	        printSumRace(raceSumLeft, raceSumRight);
	    }
	    public static void printSumRace(double raceSumLeft, double raceSumRight) {
	        if (raceSumLeft<raceSumRight) {
	            System.out.printf("The winner is left with total time: %.1f",raceSumLeft);
	        } else {
	            System.out.printf("The winner is right with total time: %.1f",raceSumRight);
	        }
	    }
	}