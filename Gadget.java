/**
 * The Gadget class represents a generic electronic device in the Gadget Shop system.
 * It acts as the superclass for more specific gadgets like Mobile and MP3.
 * It stores fundamental information such as the model, price, weight, and size.
 *
 * Author: Andres Morales
 * Date: 2026
 */
public class Gadget {

    // Attributes or fields - these are instance variables
    private String model;  // stores the model name of the gadget
    private double price;  // stores the price of the gadget in pounds
    private int weight;    // stores the weight of the gadget in grams
    private String size;   // stores the physical dimensions or size of the gadget
    
    /**
     * Constructor method which accepts a model, price, weight, and size as parameters
     * to initialize a new Gadget object.
     * @param model the name or model of the gadget
     * @param price the cost of the gadget
     * @param weight the weight of the gadget in grams
     * @param size the dimensions of the gadget
     */
    public Gadget(String model, double price, int weight, String size) {
        
        /* we use the keyword 'this' to differentiate the instance variables (this.model), 
           from the local variables passed as parameters by the constructor method (model). 
           The purpose behind this is to provide the initial values for the instance variables. */
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
        
    }
    
    /**
     * Method which returns the current value of the model instance variable.
     * @return the model of the gadget
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Method which returns the current value of the price instance variable.
     * @return the price of the gadget
     */
    public double getPrice() { 
        return price;
    }
    
    /**
     * Method which returns the current value of the weight instance variable.
     * @return the weight of the gadget
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Method which returns the current value of the size instance variable.
     * @return the size of the gadget
     */
    public String getSize() {
        return size;
    }
    
    /**
     * Method which outputs the gadget's most important details like:(model, price, weight, and size) 
     * to the system console.
     */
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }

}
