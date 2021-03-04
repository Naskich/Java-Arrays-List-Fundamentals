
/*10.	 *SoftUni Course Planning
You are tasked to help plan the next Programing Fundamentals course by keeping track of the lessons, that are going to be included in the course, as well as all the exercises for the lessons. 
On the first input line you will receive the initial schedule of lessons and exercises that are going to be part of the next course, separated by comma and space ", ". But before the course starts, there are some changes to be made. Until you receive "course start" you will be given some commands to modify the course schedule. The possible commands are: 
Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist
Remove:{lessonTitle} -remove the lesson, if it exists
Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist
Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson in the end of the course schedule, followed by the Exercise.
Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
Input
•	On the first line -the initial schedule lessons -strings, separated by comma and space ", "
•	Until "course start" you will receive commands in the format described above
Output
•	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule: 
"{lesson index}.{lessonTitle}"
•	Allowed working time / memory: 100ms / 16MB
Examples
Input	Output	Comment
Data Types, Objects, Lists
Add:Databases
Insert:Arrays:0
Remove:Lists
course start	1.Arrays
2.Data Types
3.Objects
4.Databases
	We receive the initial schedule. 
Next, we add Databases lesson, because it doesn't exist. 
We Insert at the given index lesson Arrays, because it's not present in the schedule. 
After receiving the last command and removing lesson Lists, we print the whole schedule.
Input	Output	Comment
Arrays, Lists, Methods
Swap:Arrays:Methods
Exercise:Databases
Swap:Lists:Databases
Insert:Arrays:0
course start	1.Methods
2.Databases
3.Databases-Exercise
4.Arrays
5.Lists	We swap the given lessons, because both exist.
After receiving the Exercise command, we see that such lesson doesn't exist, 
so we add the lesson at the end, followed by the exercise.
We swap Lists and Databases lessons, the Databases-Exercise is also moved after the Databases lesson.
We skip the next command, because we already have such lesson in our schedule.

 * */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        List<String> scheduleLessons = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());
        String commandSchedule = scanner.nextLine();
        while (!commandSchedule.equals("course start")){
            String [] input = commandSchedule.split(":");
            String command = input[0];
            String lessonTitle = input[1];
            if (input[0].equals("Add")){
                if (!scheduleLessons.contains(lessonTitle)) {
                    scheduleLessons.add(lessonTitle);
                }
            }
            if (command.equals("Insert")){
                int numberIndex = Integer.parseInt(commandSchedule.split(":")[2]);
                if (!scheduleLessons.contains(lessonTitle)) {
                    scheduleLessons.add(numberIndex, lessonTitle);
                }
            }
            if (input[0].equals("Remove")){

                    if (scheduleLessons.contains(lessonTitle)) {
                        scheduleLessons.remove(lessonTitle);
                    }
                    int lessonIndex = scheduleLessons.indexOf(lessonTitle);
                    if (scheduleLessons.get(lessonIndex+1).equals(lessonTitle+"-Exercise")){
                        scheduleLessons.remove(lessonIndex+1);
                    }
            }
            if (input[0].equals("Swap")){
                String secondLesson = commandSchedule.split(":")[2];
                String exerciseTitle = "-Exercise";
                        String lessonExercise1 = lessonTitle + exerciseTitle;
                        String lessonExercise2 = secondLesson + exerciseTitle;
                if (scheduleLessons.contains(lessonTitle) && scheduleLessons.contains(secondLesson)){
                        int indexSchedule1 = scheduleLessons.indexOf(lessonTitle);
                        int indexSchedule2 = scheduleLessons.indexOf(secondLesson);
                        scheduleLessons.set(indexSchedule1, secondLesson);
                        scheduleLessons.set(indexSchedule2, lessonTitle);

                        if (scheduleLessons.get(indexSchedule1+1).equals(lessonExercise1)){
                                scheduleLessons.add(indexSchedule2 + 1, lessonExercise1);
                        }
                    if (indexSchedule2 != scheduleLessons.size()-1 && scheduleLessons.get(indexSchedule2+1).equals(lessonExercise2)){
                        scheduleLessons.add(indexSchedule1 + 1,lessonExercise2);
                    }
                }
            }
            if (input[0].equals("Exercise")){
                String exerciseTitle = "-Exercise";
                    int lessonIndex = scheduleLessons.indexOf(lessonTitle);
                    if (scheduleLessons.equals(lessonTitle)) {

                        if (lessonIndex==scheduleLessons.size()-1){
                            scheduleLessons.add(lessonIndex + 1, exerciseTitle);
                        } else if (scheduleLessons.get(lessonIndex+1).equals(exerciseTitle)){
                            scheduleLessons.add(lessonIndex + 1, exerciseTitle);
                        }
                } else {
                        scheduleLessons.add(lessonTitle);
                        scheduleLessons.add(exerciseTitle);
                    }
            }
            commandSchedule = scanner.nextLine();
        }
        lessonPrint(scheduleLessons);
    }
    public static void lessonPrint(List<String> scheduleLessons) {
        int count = 0;
        for(String i : scheduleLessons){
            count+=1;
            System.out.println(count+"."+i);
        }
    }
}