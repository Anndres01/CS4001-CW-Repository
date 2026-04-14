/**
 * The MP3 class represents an MP3 music player.
 * We use the keyword 'extends' to inherit the common details from the Gadget superclass.
 * This class adds a specific attribute to keep track of the available memory.
 *
 * Author: Andres Morales
 * Date: 2026
 */
public class MP3 extends Gadget {
    
    private int availableMemory; // attribute or field - stores the memory space available in MB

    /**
     * Constructor method which accepts the 4 basic details (model, price, weight, size) 
     * plus the starting memory as parameters.
     * @param model the name of the MP3 player
     * @param price the cost of the MP3 player
     * @param weight the weight of the MP3 player in grams
     * @param size the dimensions of the MP3 player
     * @param memory the initial available memory in MB
     */
    public MP3(String model, double price, int weight, String size, int memory) {
        
        /* the super keyword calls the constructor of the Gadget superclass to save 
           the basic details there. */
        super(model, price, weight, size);

        /* we use the keyword 'this' to differentiate the instance variable availableMemory, 
           from the local memory variable passed as a parameter. This gives the MP3 its starting memory. */
        this.availableMemory = memory;
    }
    
    /**
     * Method which returns the current value of the availableMemory instance variable.
     * @return the amount of memory currently available
     */
    public int getAvailableMemory() {
        return availableMemory;
    }

    /**
     * Method which takes the size of a song as a parameter to simulate downloading music.
     * It checks if there is enough memory before downloading.
     * @param memoryNeeded the size of the music file we want to download
     */
    public void downloadMusic(int memoryNeeded) {
        
        // Checks if the availableMemory is sufficient or exactly the same as the memoryNeeded
        if (availableMemory >= memoryNeeded) {
            // if it is sufficient, subtract the needed memory from the available memory
            this.availableMemory = this.availableMemory - memoryNeeded;
            
            // this is shown if the download was successful
            System.out.println("Success! Remaining Available Memory: " + this.availableMemory + " MB");
        } else { 
            // if there is not enough available memory
            System.out.println("Insufficient Available Memory");
        }
    }
    
    /**
     * Method which takes a freed memory amount as a parameter to simulate deleting music.
     * It adds the freed space back to the available memory.
     * @param memoryFreed the amount of memory freed up by deleting files
     */
    public void deleteMusic(int memoryFreed) {
        
        // Adds the freed memory back to the available memory, giving it more "MB"space
        this.availableMemory = this.availableMemory + memoryFreed;
        
        // Message confirming the new available memory
        System.out.println("New Available Memory " + this.availableMemory + " MB");
    }
    
    /**
     * Method which overrides the display method from the Gadget class.
     * We override it to show the basic details plus the specific available memory of the MP3.
     */
    @Override
    public void display() {
        // we call the display details from the Gadget superclass to be printed first
        super.display();
        
        // then we print the available memory specifically for the MP3
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}
