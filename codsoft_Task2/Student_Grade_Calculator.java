package codsoft_Task2;
import java.util.Scanner;

public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double english,maths, physics, chemistry,computer_science;
        
        System.out.println();
        System.out.println();

        System.out.println("Enter the mark obtained in English (out of 100):");
        english = checkMark(in.nextDouble(), in, "English");     
        
        System.out.println();

        System.out.println("Enter the mark obtained in Maths (out of 100):");
        maths = checkMark(in.nextDouble(), in,"Maths");
        
        System.out.println();
        
        System.out.println("Enter the mark obtained in Physics (out of 100):");
        physics = checkMark(in.nextDouble(), in,"Physics");
        
        System.out.println();
        
        System.out.println("Enter the mark obtained in Chemistry (out of 100):");
        chemistry = checkMark(in.nextDouble(), in,"Chemistry");
        
        System.out.println();
        
        System.out.println("Enter the mark obtained in Computer Science (out of 100):");
        computer_science = checkMark(in.nextDouble(), in, "Computer Science");


        double sum = english + maths+ physics + chemistry + computer_science;
        double avg = (double) sum/5;

        
        String grade = "";
        if(avg > 90){
            grade = "A";
            System.out.println();
            System.out.println("Congratulations you have scored A grade, Keep it up!");
        }
        else if(avg >= 80){
            grade = "B";
            System.out.println();
            System.out.println("Congratulations you have scored B grade, Keep it up!");
        }
        else if(avg >= 70){
            grade = "C";
            System.out.println();
            System.out.println("Good you have scored C grade, Keep it up!");
        }
        else if(avg >= 60){
            grade = "D";
            System.out.println();
            System.out.println("Nice! You have scored D grade, Chase more!");
        }
        else if(avg >= 50){
            grade = "E";
            System.out.println();
            System.out.println("You have scored E grade, Aim higher!");
        }
        else if(avg >= 40){
            grade = "F";
            System.out.println();
            System.out.println("You have scored F grade. Don't lose hope, Aim higher!");
        }
        else{
            grade = "Fail";
            System.out.println();
            System.out.println("Sorry, you have failed. Work hard and try again!");
        }

        System.out.println("\n\t------------ Results ------------");

        System.out.println("\tTotal mark obtained : " + sum);
        System.out.printf("\tAverage mark: %.2f%%\n " ,avg);
        System.out.print("\tGrade Obtained: " + grade);
        System.out.println("\n\t---------------------------------");
    }
    public static double checkMark(double mark, Scanner in, String s){
        //double mark_return = mark;
        while(mark < 0 || mark > 100){
            System.out.println();
            System.out.println("Invalid input. Please enter a mark between 0 and 100:");
            System.out.println("Enter the mark for "+ s + " Again :" );
            mark = in.nextDouble();
        }
        return mark;
    }
}