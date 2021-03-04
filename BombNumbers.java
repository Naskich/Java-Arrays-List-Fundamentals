

/*5.	Bomb Numbers
Write a program that reads sequence of numbers and special bomb number with a certain power.
 Your task is to detonate every occurrence of the special bomb number and according to its power
  - his neighbors from left and right. Detonations are performed from left to right and all detonated
   numbers disappear. Finally print the sum of the remaining elements in the sequence.
Examples
Input	Output	Comments
1 2 2 4 2 2 2 9
4 2	12	Special number is 4 with power 2. After detonation we left with the sequence 
[1, 2, 9] with sum 12.
1 4 4 2 8 9 1
9 3	5	Special number is 9 with power 3. After detonation we left with the sequence
 [1, 4] with sum 5. Since the 9 has only 1 neighbor from the right we remove just it
  (one number instead of 3).
1 7 7 1 2 3
7 1	6	Detonations are performed from left to right. We could not detonate the
 second occurrence of 7 because its already destroyed by the first occurrence
 The numbers [1, 2, 3] survive. Their sum is 6.
1 1 2 1 1 1 2 1 1 1
2 1	4	The red and yellow numbers disappear in two sequential detonations.
 The result is the sequence [1, 1, 1, 1]. Sum = 4.
 * */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class BombNumbers {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 List<Integer> numbersBomb = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
	                .collect(Collectors.toList());
	        int sum = 0;
	        String[] input = scanner.nextLine().split("\\s+");
	        int bombNumber = Integer.parseInt(input[0]);
	        int bombPower = Integer.parseInt(input[1]);
	        while (numbersBomb.contains(bombNumber)) {
	            int indexBomb = numbersBomb.indexOf(bombNumber);
	            
	            int left = Math.max(0, indexBomb - bombPower);
	            int right = Math.min(numbersBomb.size() - 1, indexBomb + bombPower);
	            
	            for (int i = right; i >= left; i--) {
	                numbersBomb.remove(i);
	            }
	        }
	        
	        for (int i = 0; i < numbersBomb.size(); i++) {
	            sum += numbersBomb.get(i);
	        }
	        System.out.println(sum);
	 
	    }
	}