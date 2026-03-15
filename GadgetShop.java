import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GadgetShop extends Application {
    //1.Text fields for gadget attributes

    private final TextField modelField = new TextField();
    private final TextField priceField = new TextField();
    private final TextField weightField = new TextField();
    private final TextField sizeField = new TextField();
    //This are specific attributes some for "Mobile" and some others for "MP3"
    private final TextField creditField = new TextField();
    private final TextField memoryField = new TextField();
    private final TextField displayNumberField = new TextField();
    private final TextField phoneNumberField = new TextField();
    private final TextField durationField = new TextField();
    private final TextField downloadSizeField = new TextField();

    //Where the result will be shown 
    private final TextArea logArea = new TextArea();

    //ready to save the Gadgets
    private final ArrayList<Gadget> gadgets = new ArrayList<>();

    //2. The method to start building the window
    @Override
    public void start (Stage stage) {
        Pane root = new Pane ();

        //Model input field
        Label modelLabel = new Label("Model: ");
        modelLabel.setLayoutX(20);
        modelLabel.setLayoutY(20);

        modelField.setLayoutX(120);
        modelField.setLayoutY(20);

        //Price input field
        Label priceLabel = new Label("Price (£): ");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(60);

        priceField.setLayoutX(120);
        priceField.setLayoutY(60);

        //Weight input field
        Label weightLabel = new Label("Weight (g):");
        weightLabel.setLayoutX(20);
        weightLabel.setLayoutY(100);

        weightField.setLayoutX(120);
        weightField.setLayoutY(100);

        //Size input field
        Label sizeLabel = new Label("Size: ");
        sizeLabel.setLayoutX(20);
        sizeLabel.setLayoutY(140);

        sizeField.setLayoutX(120);
        sizeField.setLayoutY(140);

        //Credit(Mobile)
        Label creditLabel = new Label("Credit:");
        creditLabel.setLayoutX(20);
        creditLabel.setLayoutY(180);

        creditField.setLayoutX(120); 
        creditField.setLayoutY(180);

        //Memory(MP3)
        Label memoryLabel = new Label("Memory:");
        memoryLabel.setLayoutX(20);
        memoryLabel.setLayoutY(220);

        memoryField.setLayoutX(120); 
        memoryField.setLayoutY(220);

        //INPUT FIELDS FOR ACTIONS (MAKE A CALL & DOWNLOAD MUSIC)

        // 1. Display Number: Indicates the position of the gadget in the list (0, 1, 2...)
        Label displayNumLabel = new Label("Display Number:");
        displayNumLabel.setLayoutX(20);
        displayNumLabel.setLayoutY(260);

        displayNumberField.setLayoutX(120);
        displayNumberField.setLayoutY(260);

        // 2. Phone Number: The phone number the user wants to call.
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setLayoutX(20);
        phoneLabel.setLayoutY(300);

        phoneNumberField.setLayoutX(120);
        phoneNumberField.setLayoutY(300);

        // 3. Duration: How many minutes the call lasts
        Label durationLabel = new Label("Duration (min):");
        durationLabel.setLayoutX(20);
        durationLabel.setLayoutY(340);

        durationField.setLayoutX(120);
        durationField.setLayoutY(340);

        // 4. Download Size: The size in MB of the song to download
        Label downloadLabel = new Label("Download (MB):");
        downloadLabel.setLayoutX(20);
        downloadLabel.setLayoutY(380);

        downloadSizeField.setLayoutX(120);
        downloadSizeField.setLayoutY(380);

        //Buttons required
        //First set of buttons( MP3, Mobile)
        Button addMP3Button = new Button("Add Mp3");
        addMP3Button.setLayoutX(20);
        addMP3Button.setLayoutY(430);
        // When the button is clicked, it calls the method that creates and saves the MP3.
        addMP3Button.setOnAction(e -> handleAddMP3Button());

        Button addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(120);
        addMobileButton.setLayoutY(430);
        // When the button is clicked, it calls the method that creates and saves the mobile phone.
        addMobileButton.setOnAction(e -> handleAddMobileButton());

        //Second set of buttons(Make a call, download music)
        //Button addMake
        Button makeCallButton = new Button("Make A Call");
        makeCallButton.setLayoutX(20);
        makeCallButton.setLayoutY(470);
        // When the button is clicked, it calls the method to make a call
        makeCallButton.setOnAction(e -> handleMakeCallButton());

        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(120);
        downloadMusicButton.setLayoutY(470);
        // When the button is clicked, it calls the method to download the music
        downloadMusicButton.setOnAction(e -> handleDownloadMusicButton());
        
        //Third set of buttons(Dispay all, Clear)
        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(20);
        displayAllButton.setLayoutY(510);
        // When the button is clicked, it calls the method that Displays all the devices added
        displayAllButton.setOnAction(e -> handleDisplayAllButton());

        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(120);
        clearButton.setLayoutY(510);
        //This part makes the button actually work when is click
        clearButton.setOnAction(e-> clearAllFields());

        //LogArea on the right of the window 
        logArea.setLayoutX(350);
        logArea.setLayoutY(20);
        logArea.setPrefWidth(220); // We give a fixed width
        logArea.setPrefHeight(510); //We give a fixed Height

        //This part makes the buttons visible 
        root.getChildren().addAll(
            modelLabel, modelField, priceLabel, priceField,
            weightLabel, weightField, sizeLabel, sizeField,
            creditLabel, creditField, memoryLabel, memoryField,
            displayNumLabel, displayNumberField, phoneLabel, phoneNumberField,
            durationLabel, durationField, downloadLabel, downloadSizeField,    
            addMobileButton, addMP3Button, makeCallButton, downloadMusicButton,
            displayAllButton, clearButton, logArea
        );

        //Set the final configuration for the window
        //This part gives a size to the general window and makes it visible 
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Gadget Shop App");
        stage.show();
    }

    //Method to create a MP3 and save it
    private void handleAddMP3Button() {
        // 1. Collect the data
        String model = modelField.getText();
        String size = sizeField.getText();
        //// Converts the text entered into a decimal number , removing any accidental spaces
        double price = Double.parseDouble(priceField.getText().trim());
        //// Convert the weight text to an integer
        int weight = Integer.parseInt(weightField.getText().trim());
        // Convert the text from memory to an integer
        int memory = Integer.parseInt(memoryField.getText().trim()); 

        // 2. Creates the MP3 and saves it
        MP3 newMP3 = new MP3(model, price, weight, size, memory);
        gadgets.add(newMP3);

        // 3. Confirmation message 
        logArea.appendText("MP3 added: " + model + " (" + memory + " MB)\n");
    }

    //Method to create a Mobile and save it 
    private void handleAddMobileButton() {
        // 1. Collect the data
        String model = modelField.getText();
        String size = sizeField.getText();
        double price = Double.parseDouble(priceField.getText());
        int weight = Integer.parseInt(weightField.getText());
        int credit = Integer.parseInt(creditField.getText());

        // 2. Create object and saves it 
        Mobile newMobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(newMobile);

        // 3. Confirmation message
        logArea.appendText("Added Mobile: " + model + "\n");
    }
    
    // Method to safely get and validate the Display Number using try/catch
    private int getDisplayNumber() {
        int displayNum = -1; // Initialise to -1 as requested 
        
        try {
            // Attempt to read the text and convert it to an integer
            displayNum = Integer.parseInt(displayNumberField.getText().trim());
            
            // Check if the number is within the valid range of our ArrayList
            if (displayNum < 0 || displayNum >= gadgets.size()) {
                // Not in range: Show a Dialog Box error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("Invalid Display Number Range");
                alert.setContentText("The display number " + displayNum + " does not exist. Please enter a number between 0 and " + (gadgets.size() - 1) + ".");
                alert.showAndWait();
                
                displayNum = -1; // Reset to -1 because it's invalid
            }
        } catch (NumberFormatException e) {
            // Not a number (e.g., text or empty): Show a different Dialog Box error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Invalid Data Type");
            alert.setContentText("Please enter a valid whole number (integer) for the Display Number.");
            alert.showAndWait();
            
            displayNum = -1; // Reset to -1 because it's invalid
        }
        
        return displayNum; // Returns the valid number, or -1 if there was any error
    }
    
    // Method to show all save gadgets 
    private void handleDisplayAllButton() {
        // 1.This part is made to clear the logArea from previous details displays on it 
        logArea.clear();
        logArea.appendText("=== Gadget List ===\n");
        // 2. Loop "for" that goes over our list from 0 to the end 
        for (int i = 0; i < gadgets.size(); i++) {

            // Print the display number as is ask for 
            logArea.appendText("Display Number: " + i + "\n");

            // Takes the gadget from that position 
            Gadget currentGadget = gadgets.get(i);

            // We call the method display() from our class 
            currentGadget.display();

            // Shows a resume on our white window 
            logArea.appendText("Model: " + currentGadget.getModel() + " - £" + currentGadget.getPrice() + "\n");
            logArea.appendText("--------------------\n");
        }
    }
    

  // Method to make a call using a Mobile gadget
    private void handleMakeCallButton() {
        // 1. Get the display number using our safe method
        int displayNum = getDisplayNumber();
        
        // 2. Only proceed if the display number is valid (not -1)
        if (displayNum != -1) {
            String phoneNumber = phoneNumberField.getText();
            int duration = Integer.parseInt(durationField.getText().trim());
            
            // Retrieves the gadget from the ArrayList using the valid display number
            Gadget currentGadget = gadgets.get(displayNum);
            
            // Casts the generic Gadget object into a Mobile object
            Mobile mobile = (Mobile) currentGadget;
            
            // Calls the makeCall method in the Mobile class passing the input values
            mobile.makeCall(phoneNumber, duration);
            
            // Displays a confirmation message in the text area
            logArea.appendText("Calling " + phoneNumber + " for " + duration + " minutes.\n");
        }
    }
    
   // Method to download music to an MP3 gadget
    private void handleDownloadMusicButton() {
        // 1. Get the display number using our safe method
        int displayNum = getDisplayNumber();
        
        // 2. Only proceed if the display number is valid (not -1)
        if (displayNum != -1) {
            int downloadSize = Integer.parseInt(downloadSizeField.getText().trim());
            
            // Retrieves the gadget from the ArrayList using the valid display number
            Gadget currentGadget = gadgets.get(displayNum);
            
            // Casts the generic Gadget object into an MP3 object
            MP3 mp3 = (MP3) currentGadget;
            
            // Calls the downloadMusic method in the MP3 class passing the input size
            mp3.downloadMusic(downloadSize);
            
            // Displays a confirmation message in the text area
            logArea.appendText("Downloaded " + downloadSize + " MB to MP3.\n");
        }
    }
    
    //Method to clear every Field
    private void clearAllFields(){
        modelField.clear();
        priceField.clear();
        weightField.clear();
        sizeField.clear();
        creditField.clear();
        memoryField.clear();   
    }
    //The main method to make javaFX work
    public static void main(String[] args) { launch(); }
}