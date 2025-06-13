package Task3;
import java.util.Scanner;
public class ATM {
    private Bank_Account account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(Bank_Account account){
        this.account = account;
        
    }
    public void start() {
        while (true) {
            System.out.println("\n--- Welcome to the ATM ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    handleDeposit();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.out.println();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    void checkBalance(){
        System.out.print("Your Current Account balance: ");
        System.out.println(account.getBalance());

    }

    void handleWithdraw(){
        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();
        if(amount > 0){
            if( account.withdraw(amount)){
                System.out.println("Withdraw successful");
                System.out.print("Remaining Balance in the account : ");
                 System.out.println(account.getBalance());
            }
        }
        else{
            System.out.println("Withdraw Failed, Insufficient balance or invalid amount");
        }
    }

    void handleDeposit(){
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextInt();
        if(amount > 0){
            account.deposit(amount);
            System.out.println("Deposit successful");
            System.out.print("Balance after deposit : ");
            System.out.println(account.getBalance());
        }
    }
}
