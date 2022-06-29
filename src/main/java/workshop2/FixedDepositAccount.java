package workshop2;

public class FixedDepositAccount extends BankAccount {
    
    private float interest = 3f;
    private int duration = 6;
    private int durationInterestCounter = 0; 

    //overloaded constructors; the compiler determines the constructor to be invoked based 
    // on the number of input parameters 
    public FixedDepositAccount(String name, Float initialAmount) {
        super(name, initialAmount); 
        this.durationInterestCounter = 0;
    }
    public FixedDepositAccount(String name, Float initialAmount, Float interest) {
        super(name, initialAmount);
        this.interest = interest; 
        this.durationInterestCounter = 0;
    }
    public FixedDepositAccount(String name, Float initialAmount, Float interest, Integer duration) {
        super(name, initialAmount);
        this.interest = interest; 
        this.duration = duration;
        this.durationInterestCounter = 0;
    }

    // set up getter and setter for all interest/duration objects 
    public float getInterest() {
        return interest;
    }
    private void setInterest(float interest) {
        //throw illegal argument exception in the case that interest is an invalid amount 
        if(interest < 0) {
            throw new IllegalArgumentException("Interest cannot be less than 0! ");
        }
        this.interest = interest;
    }
    public int getDuration() {
        return duration;
    }
    private void setDuration(int duration) {
        //throw illegal argument exception in the case that duration is an invalid amount 
        if(duration < 0) {
            throw new IllegalArgumentException("Duration cannot be less than 0! ");
        }
        this.duration = duration;
    }

    // set up interest and duration counter 
    public void setDurationInterestCounter(float interest, int duration) {
        if(durationInterestCounter == 1) {
            throw new IllegalArgumentException("Interest and duration can only be modified once! ");
        }
        //each time interest or duration is set, the durationinterestcounter increase by 1. 
        setInterest(interest); 
        setDuration(duration);
        durationInterestCounter++; 
    }

    //set up withdraw / deposit / getbalance; hint: use the overriden access modifier
    @Override
    public float withdraw (String withdrawAmt) {
        //No operation
        return 0f; 
    }

    @Override
    public float deposit (String depositAmt) { 
        //no operation
        return 0f; 
    }

    @Override
    //use getAcctBal instead of acctBal because this is the public class vs private class
    public float getAcctBal() {
        return super.getAcctBal() + (interest * super.getAcctBal()/100); 
    }    
}
