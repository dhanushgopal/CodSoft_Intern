package Task3;

public class Bank_Account {
    private double balance;

    public Bank_Account(double initial_balance){
        this.balance = initial_balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
        
    }

    public void deposit(double amount){
        balance += amount;
    }

}
