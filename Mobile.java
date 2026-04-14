/**
 * The Mobile class represents a mobile phone.
 * We use the keyword 'extends' to inherit all the attributes and methods from the Gadget superclass.
 * This class adds a specific attribute just for calling credit.
 *
 * Author: Andres Morales
 * Date: 2026
 */
public class Mobile extends Gadget {
    
    private int credit; // attribute or field - stores the integer for call credit
    
    /**
     * Constructor method which accepts the 4 basic details (model, price, weight, size) 
     * plus the specific calling credit as parameters.
     * @param model the name of the mobile
     * @param price the cost of the mobile
     * @param weight the weight of the mobile in grams
     * @param size the dimensions of the mobile
     * @param credit the initial amount of calling credit
     */
    public Mobile(String model, double price, int weight, String size, int credit) {
        
        /* the super keyword calls the constructor of the Gadget superclass and passes 
           the 4 basic details to be saved there. */
        super(model, price, weight, size);
        
        /* we use the keyword 'this' to differentiate the instance variable credit (this.credit), 
           from the local credit variable passed as a parameter. The purpose of this is to save 
           the new detail in our variable for this specific class. */
        this.credit = credit;
    }
    
    /**
     * Method which returns the current value of the credit instance variable.
     * @return the available calling credit
     */
    public int getCredit() {
        return credit;
    }
    
    /**
     * Method which takes as a parameter an amount to add to the existing credit.
     * It prints a success message if the amount is positive.
     * @param amount the number of credits to add
     */
    public void addCredit(int amount) {
        if (amount > 0) {
            // sum the amount to the credit if the amount is positive
            this.credit = this.credit + amount;
            System.out.println("Success! New credit: " + this.credit);
        } else {
            // in case they enter a negative number or 0
            System.out.println("Please enter a positive amount");
        }
    }
    
    /**
     * Method which takes a phone number and a duration as parameters to simulate making a call.
     * It checks if the credit is sufficient before making the call.
     * @param phoneNumber the number we want to call
     * @param duration how many minutes the call lasts
     */
    public void makeCall(String phoneNumber, int duration) {
        
        // Checks if the credit is sufficient or the same as the duration
        if (credit >= duration) {
            // if is sufficient, subtract the duration from the credit
            this.credit = this.credit - duration;
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes");
        } else {
            // this shows if there are not enough credits
            System.out.println("Insufficient credit to make this call");
        }
    }
  
    /**
     * Method which overrides the display method from the Gadget class.
     * We override it to show the basic details plus the remaining credit of the mobile.
     */
    @Override
    public void display() {
        // we call the display details from the Gadget superclass to be printed first
        super.display();
        
        // then we print the remaining credit specifically for the mobile
        System.out.println("Calling credit remaining: " + this.credit);
    }
}
