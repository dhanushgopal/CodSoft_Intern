package codsoft_Task3;
// import Task3.ATM;
public class Driver {
    public static void main(String[] args) {
        Bank_Account usr_acc = new Bank_Account(1000);
        ATM atm = new ATM(usr_acc);
        atm.start();
    }
}
