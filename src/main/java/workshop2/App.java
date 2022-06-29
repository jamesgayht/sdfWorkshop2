package workshop2;

public class App 
{
    public static void main( String[] args )
    {
        // System.out.println("Welcome to your ATM! How may we assist today? ");
        // //create the bank account for the new user 
        // BankAccount bankacct = new BankAccount("James's bank account! "); 
        // //input commands from the user for testing 
        // // bankacct.deposit("1000"); 
        // // return the balance after required action 
        // System.out.println("New account balance " + bankacct.deposit("1000"));
        // System.out.println("New account balance " + bankacct.withdraw("1500"));

        //create new fdaccount 
        FixedDepositAccount fdAcct = new FixedDepositAccount("James FD Account", 10000f); 

        // print fd account balance 
        System.out.println("FD acct balance " + fdAcct.getAcctBal() + ".");
        // set new duration and interest 
        fdAcct.setDurationInterestCounter(4f, 6);
        // print fd account balance 
        System.out.println("FD acct balance " + fdAcct.getAcctBal() + ".");
        fdAcct.setDurationInterestCounter(6f, 1);




        
    }
}
