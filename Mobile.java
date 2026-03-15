//we use the keyword "extends" as inheritance from the subclass (Gadget)
public class Mobile extends Gadget {
    
    //1. Attribute 
    //Is use to declare the integer for call credit 
    private int credit;
    
    //2.Constructor 
    //It needs to recieve 5 details: model, price, weight, size, credit.
    public Mobile (String model, double price, int weight, String size, int credit){
       //Calls the superclass (Gadget)constructor
       super(model, price, weight, size);
       
       //Saves the new detail in our variable for this class
       this.credit = credit;
    }
    
    //3.Getter
    public int getCredit(){
        return credit;
    }
    
    //this is to add credits
    public void addCredit(int amount){
        if (amount > 0) {
            //how to sum the amount to the credit if the amount is positive
           this.credit = this.credit + amount;
           System.out.println("Success! New credit: " +this.credit);
           
        }else{
            //in case they enter a negative number or 0
            System.out.println("Please enter a positive amount");
        }
        }
    
    //this method is to make a call
    public void makeCall(String phoneNumber, int duration){
        
        //Cheks if the credit is sufficient or the same as the duration
        if (credit >= duration){
        //if is sufficient
        this.credit = this.credit - duration;
        System.out.println("Calling " + phoneNumber + " for " + duration + " minutes");
        
    }else{//if is not sufficient
        //this is shows if is not enough credits
        System.out.println("Insufficient credit to make this call");
    }
  }
  
  @Override
  //Method to show the details of the phone
  public void display(){
      //we call the display details from the (Gadget)to be print
      super.display();
      //to print the remaining credit 
      System.out.println("Calling credit remaining: " + this.credit);
  }
}
