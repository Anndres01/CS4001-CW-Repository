//we use the Keyword (extends) to as inheritance from the subclass (Gadget)
public class MP3 extends Gadget{
    //1.Attribute 
    private int availableMemory;

    //2.Constructor
    //Recieves : model, price, weight, size, Memory
    public MP3(String model, double price, int weight, String size, int memory){
        //Calls the superclass (Gadget)constructor
        super(model, price, weight, size);

        //Initializes the new variable (this.availableMemory)
        this.availableMemory = memory;
    }
    //3.Getter
    //Method to return the available memory
    public int getAvailableMemory(){
        return availableMemory;

    }

    //Method to download music
    public void downloadMusic(int memoryNeeded){
        //Checks  if the availableMemory is sufficient or the same as the memoryNeeded
        if(availableMemory >= memoryNeeded){
            //if it is sufficient
            this.availableMemory = this.availableMemory - memoryNeeded;
            //this is shown if there is enough memory available
            System.out.println("Success! Remaining Available Memory: " + this.availableMemory + " MB");
        }else{ //if is not sufficient available memory 
            System.out.println("Insufficient Available Memory");

        }
    }
    //Method to delete music
    public void deleteMusic(int memoryFreed){
        //Initializes the memory freed to the avaible memory giving it more space available
        this.availableMemory = this.availableMemory + memoryFreed;
        //Message confirming your new available memory 
        System.out.println("New Available Memory " + this.availableMemory + " MB");
    }
    
    @Override
    //Method to show the details of the MP3
    public void display(){
        //we call the display details from the (Gadget)to be print
        super.display();
        //Prints the available memory  
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}