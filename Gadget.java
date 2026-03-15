
public class Gadget{
    //1.Attributes
    //The price is a decimal number, the weight is an integer, and the model and the size are strings of text.
   private String model;
   private double price;
   private int weight;
   private String size;
   
   //2. Constructor 
   //This method is used when you created a new Gadget.
   //Recieve the data and save it on the variables above. 
   public Gadget (String model, double price, int weight, String size){
    
    this.model = model;
    this.price = price;
    this.weight = weight;
    this.size = size;
    
    }
    
   //3. Getters
   //they are use to "take" a value from a variable to the outside.
   public String getModel(){
    return model;
    }
    
    public double getPrice(){ 
        return price;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public String getSize(){
        return size;
    }
    
    //4.Dispay method
    //Is use to print the details 
    public void display(){
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }


}