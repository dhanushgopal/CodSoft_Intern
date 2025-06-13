package Task1;

import java.util.Scanner;
import java.util.Random;

public class Number_Program {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner inpu = new Scanner(System.in);

        System.out.println("***********************************************");
        System.out.println("\t Number Guessing Game\t");
        System.out.println("***********************************************");
        System.out.println("Rules : ");
        System.out.println("You will have 7 attempts");
        System.out.println("You have to guess the number within 7 attempts");
        System.out.println("If you guess the number correctly you win else you lose");
        System.out.println();

        int roundsPlayed = 0;
        int roundsWon = 0;

        boolean play_again = true;

        while (play_again) {
            int random_number = random.nextInt(100) + 1;
            roundsPlayed++;
            boolean won = playGame(random_number, inpu);
            if (won) {
                roundsWon++;
            }

            System.out.println("Do you want to continue playing (yes/no): ");
            String getin = inpu.nextLine().toLowerCase();

            if (getin.equals("yes")) {
                play_again = true;
            } else {
                System.out.println();
                System.out.println();
                System.out.println("--------------- Final Score ---------------");
                System.out.println("Total Rounds Played: " + roundsPlayed);
                System.out.println("Rounds Won        : " + roundsWon);
                System.out.println("Rounds lost       : " + (roundsPlayed - roundsWon));
                System.out.println();
                System.out.println("\t    Thanks for playing!");
                System.out.println("-------------------------------------------");
                System.out.println();
                play_again = false;
            }
        }
        inpu.close();
    }

    public static boolean playGame(int random_number, Scanner inpu) {
        int attempts = 7;
        boolean guessed_crt = false;

        while (attempts > 0) {
            System.out.println();
            System.out.println("Enter the number between (1 - 100): ");
            int usr_number = inpu.nextInt();
            if (usr_number >= 0 && usr_number <= 100) {
                inpu.nextLine();

                if (usr_number == random_number) {
                    System.out.println("Random Number :" + random_number);
                    System.out.println("User Number   :" + usr_number);
                    System.out.println("Congratulation, you have guessed the correct number ");
                    attempts--;
                    System.out.println("No. of attempts Left " + attempts);
                    guessed_crt = true;
                    break;
                } else if (usr_number > random_number) {
                    System.out.println("Guessed number is too HIGH ");
                    attempts--;
                    System.out.println("No. of attempts Left " + attempts);
                } else {
                    System.out.println("Guessed number is too low");
                    attempts--;
                    System.out.println("No. of attempts Left " + attempts);
                }
            } else {
                System.out.println("Enter the correct number and continue");
            }
        }

        if (!guessed_crt) {
            System.out.println("You've used all your attempts. The correct number was: " + random_number);
        }

        return guessed_crt;
    }
}
