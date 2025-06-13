package Task4;


import java.util.*;

public class QuizApplicationWithTimer {

    static class Question {
        String question;
        String[] options;
        int correctAnswerIndex;

        public Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static int score = 0;
    static List<String> summary = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?",
                new String[]{"1) London", "2) Paris", "3) Berlin", "4) Rome"}, 2));
        questions.add(new Question("Which language runs in a web browser?",
                new String[]{"1) Java", "2) C", "3) Python", "4) JavaScript"}, 4));
        questions.add(new Question("What is 5 + 3?",
                new String[]{"1) 8", "2) 7", "3) 5", "4) 6"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"1) Earth", "2) Venus", "3) Mars", "4) Jupiter"}, 3));
        questions.add(new Question("Who is the founder of Microsoft?",
                new String[]{"1) Steve Jobs", "2) Elon Musk", "3) Mark Zuckerberg", "4) Bill Gates"}, 4));

        System.out.println("Welcome to the Quiz Application");
        System.out.println("\nYou will have 10 seconds to answer each question.");
        System.out.println("Get Ready...\n");
        Thread.sleep(3000);

        for (int i = 0; i < questions.size(); i++) {
            askQuestion(questions.get(i), i + 1);
            System.out.println("\nNext Question Coming Up!!!\n");
        }

        System.out.println("Quiz Completed!");
        System.out.println("Final Score: " + score + " out of " + questions.size());
        System.out.println("\nSummary:");
        for (String s : summary) {
            System.out.println(s);
        }
    }

    public static void askQuestion(Question q, int questionNumber) throws InterruptedException {
        System.out.println("Q" + questionNumber + ": " + q.question);
        for (String option : q.options) {
            System.out.println(option);
        }

        final boolean[] answered = {false};
        final String[] inputHolder = {null};

        Thread inputThread = new Thread(() -> {
            System.out.print("Enter your answer (1-4): ");
            inputHolder[0] = scanner.nextLine();
            answered[0] = true;
        });

        inputThread.start();

        int timeWaited = 0;
        while (timeWaited < 10 && !answered[0]) {
            Thread.sleep(1000);
            timeWaited++;
        }

        if (!answered[0]) {
            inputThread.interrupt(); // Optional: doesn't actually stop input in console
            System.out.println("\nTime's up! No answer submitted.");
            summary.add("Q" + questionNumber + ": Time Up");
            return;
        }

        try {
            int answer = Integer.parseInt(inputHolder[0].trim());
            if (answer == q.correctAnswerIndex) {
                System.out.println("Correct!");
                score++;
                summary.add("Q" + questionNumber + ": Correct");
            } else {
                System.out.println("Incorrect. The correct answer was option " + q.correctAnswerIndex);
                summary.add("Q" + questionNumber + ": Incorrect");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Skipping question.");
            summary.add("Q" + questionNumber + ": Invalid Input");
        }
    }
}
