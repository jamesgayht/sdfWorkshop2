package workshop2;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

//the bank account class handles the withdrawals/deposits 
public class BankAccount {

    // bank account holder's name 
    private final String accHolderName; 
    //random generated account ID using UUID 
    //use toString to convert to string object and substring to trim down to 8 chars, if not default will be 36
    private final String acctId = UUID.randomUUID().toString().substring(0, 8);   
    //holds the bank account balance 
    private float acctBal; 
    //create a list to track the transaction changes on bank acc's obj
    // e.g. all withdrawals, deposits, creation, closure, etc
    List<String> acctTxns = new LinkedList<>(); 
    //boolean to state whether the account is closed
    boolean isClosed = false; 
    //create the creation/closing dates 
    private LocalDateTime acctCreationDate; 
    private LocalDateTime acctCloseDate; 
    
    //FIRST CONSTRUCTOR with bank account name and bal 0 (as per quex);
    public BankAccount(String accHolderName) {
        this.accHolderName = accHolderName; 
        acctBal = 0f;
    }
    

    //SECOND CONSTRUCTOR with bank account name and inital bal; 

    public BankAccount(String accHolderName, float acctBal) {
        this.accHolderName = accHolderName; 
        this.acctBal = acctBal;
    }

    // create getters and setters for all private properties 
    public String getAccHolderName() {
        return accHolderName;
    }


    public String getAcctId() {
        return acctId;
    }


    public float getAcctBal() {
        return acctBal;
    }


    public void setAcctBal(float acctBal) {
        this.acctBal = acctBal;
    }


    public List<String> getAcctTxns() {
        return acctTxns;
    }


    public void setAcctTxns(List<String> acctTxns) {
        this.acctTxns = acctTxns;
    }


    public boolean isClosed() {
        return isClosed;
    }


    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }


    public LocalDateTime getAcctCreationDate() {
        return acctCreationDate;
    }


    public void setAcctCreationDate(LocalDateTime acctCreationDate) {
        this.acctCreationDate = acctCreationDate;
    }


    public LocalDateTime getAcctCloseDate() {
        return acctCloseDate;
    }


    public void setAcctCloseDate(LocalDateTime acctCloseDate) {
        this.acctCloseDate = acctCloseDate;
    }    

    // create the withdrawal class
    public float withdraw (String withdrawAmt) {
        //initialize the float amount from the string input 
        float withdrawAmtF = Float.parseFloat(withdrawAmt);

        //use try catch in case input <= 0 || bank acct is currently closed || input > acct bal
        try {
            if(withdrawAmtF <= 0) {
                throw new IllegalArgumentException("Withdraw amount has to be more than 0! "); 
            }
            if(this.isClosed()) {
                throw new IllegalArgumentException("Bank account is closed! "); 
            } 
            if(withdrawAmtF > this.acctBal) {
                throw new IllegalArgumentException("OI, not enough in your account la! "); 
            }
            // if withdrawal cmd is fine, use StringBuilder to create the history log 
            //rmb to also update the balance amount after withdrawal 
            // e.g. "Withdraw $" + "amt" + "at" + "Local date time" - print for user reference 
            this.acctBal = this.acctBal - withdrawAmtF;
            StringBuilder txnBuilder = new StringBuilder();
            txnBuilder.append("Withdraw $"); 
            txnBuilder.append(withdrawAmtF); 
            txnBuilder.append(" at "); 
            txnBuilder.append(LocalDateTime.now());
            System.out.println(txnBuilder.toString());
            // save the log into the txn list 
            acctTxns.add(txnBuilder.toString()); 

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdrawal amount! ");
        }
        // update the final balance amount 
        return this.acctBal;
    }
    // create the deposit class
    public float deposit(String depositAmt) {

        //initialise the float amount from the string input
        //use try catch in case  input <= 0 || bank acct is currently closed 
        float depositAmtF = Float.parseFloat(depositAmt); 
        try {
            if(depositAmtF <= 0) {
                throw new IllegalArgumentException("Deposit amount must be more than 0! ");
            }
            if (this.isClosed()) {
                throw new IllegalArgumentException("Bank account is closed! "); 
            }
            // if deposit cmd is fine, use StringBuilder to create the history log 
            // rmb to update the balance amount after deposit
            // e.g. "deposit $" + "amt" + "at" + "Local date time" - print for user reference 
            this.acctBal = this.acctBal + depositAmtF;
            StringBuilder txnBuilder = new StringBuilder(); 
            txnBuilder.append("Deposit $"); 
            txnBuilder.append(depositAmtF);
            txnBuilder.append(" at "); 
            txnBuilder.append(LocalDateTime.now());
            // print for user reference 
            System.out.println(txnBuilder.toString());
            // save the log into the txn list 
            acctTxns.add(txnBuilder.toString()); 

        } catch (NumberFormatException e) {
            System.err.print(e); 
            throw new IllegalArgumentException("Invalid deposit amount! ");
        }
        // update the account bal amount 
        return this.acctBal; 
    }  
}


