import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * The GadgetShop class provides a Graphical User Interface (GUI) for the Gadget Shop application.
 * It extends the JavaFX Application class to create a window where users can add Mobile and MP3
 * gadgets to an inventory, view them, and interact with them (make calls, download music).
 *
 * Author: Andres Morales
 * Date: 2026
 */
public class GadgetShop extends Application {

    // Text fields for general gadget attributes
    private final TextField modelField = new TextField(); // stores the model input from the user
    private final TextField priceField = new TextField(); // stores the price input from the user
    private final TextField weightField = new TextField(); // stores the weight input from the user
    private final TextField sizeField = new TextField(); // stores the size input from the user
    
    // Text fields for specific subclass attributes (Mobile and MP3)
    private final TextField creditField = new TextField(); // stores the calling credit input for a Mobile
    private final TextField memoryField = new TextField(); // stores the available memory input for an MP3
    
    // Text fields for performing actions
    private final TextField displayNumberField = new TextField(); // stores the index of the gadget to interact with
    private final TextField phoneNumberField = new TextField(); // stores the phone number to call
    private final TextField durationField = new TextField(); // stores the duration of the call in minutes
    private final TextField downloadSizeField = new TextField(); // stores the size of the music to download in MB

    // Display area and storage
    private final TextArea logArea = new TextArea(); // stores and displays the visual output and gadget list for the user
    private final ArrayList<Gadget> gadgets = new ArrayList<>(); // stores the collection of Gadget objects created

    /**
     * Initializes and builds the Graphical User Interface (GUI) for the application.
     * * @param stage the primary stage for this application, onto which the application scene can be set
     */
    @Override
    public void start(Stage stage) {
        // override start from the Application class so we can build our specific JavaFX layout and controls
        Pane root = new Pane();

        // Model input field to be able to set where are you putting in the GUI window
        Label modelLabel = new Label("Model: ");
        modelLabel.setLayoutX(20);
        modelLabel.setLayoutY(20);
        modelField.setLayoutX(120);
        modelField.setLayoutY(20);

        // Price input field
        Label priceLabel = new Label("Price (£): ");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(60);
        priceField.setLayoutX(120);
        priceField.setLayoutY(60);

        // Weight input field
        Label weightLabel = new Label("Weight (g):");
        weightLabel.setLayoutX(20);
        weightLabel.setLayoutY(100);
        weightField.setLayoutX(120);
        weightField.setLayoutY(100);

        // Size input field
        Label sizeLabel = new Label("Size: ");
        sizeLabel.setLayoutX(20);
        sizeLabel.setLayoutY(140);
        sizeField.setLayoutX(120);
        sizeField.setLayoutY(140);

        // Credit (Mobile)
        Label creditLabel = new Label("Credit:");
        creditLabel.setLayoutX(20);
        creditLabel.setLayoutY(180);
        creditField.setLayoutX(120); 
        creditField.setLayoutY(180);

        // Memory (MP3)
        Label memoryLabel = new Label("Memory:");
        memoryLabel.setLayoutX(20);
        memoryLabel.setLayoutY(220);
        memoryField.setLayoutX(120); 
        memoryField.setLayoutY(220);

        // INPUT FIELDS FOR ACTIONS (MAKE A CALL & DOWNLOAD MUSIC)

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

        // Buttons required
        // First set of buttons (MP3, Mobile)
        Button addMP3Button = new Button("Add Mp3");
        addMP3Button.setLayoutX(20);
        addMP3Button.setLayoutY(430);
        addMP3Button.setOnAction(e -> handleAddMP3Button()); // links button to the MP3 creation method

        Button addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(120);
        addMobileButton.setLayoutY(430);
        addMobileButton.setOnAction(e -> handleAddMobileButton()); // links button to the Mobile creation method

        // Second set of buttons (Make a call, download music)
        Button makeCallButton = new Button("Make A Call");
        makeCallButton.setLayoutX(20);
        makeCallButton.setLayoutY(470);
        makeCallButton.setOnAction(e -> handleMakeCallButton()); // links button to the calling method

        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(120);
        downloadMusicButton.setLayoutY(470);
        downloadMusicButton.setOnAction(e -> handleDownloadMusicButton()); // links button to the download method

        // Third set of buttons (Display all, Clear)
        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(20);
        displayAllButton.setLayoutY(510);
        displayAllButton.setOnAction(e -> handleDisplayAllButton()); // links button to the display method

        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(120);
        clearButton.setLayoutY(510);
        clearButton.setOnAction(e -> clearAllFields()); // links button to the clear method

        // LogArea on the right of the window 
        logArea.setLayoutX(350);
        logArea.setLayoutY(20);
        logArea.setPrefWidth(220); // set a fixed width
        logArea.setPrefHeight(510); // set a fixed height

        // This part makes the buttons visible in the window/GUI
        root.getChildren().addAll(
            modelLabel, modelField, priceLabel, priceField,
            weightLabel, weightField, sizeLabel, sizeField,
            creditLabel, creditField, memoryLabel, memoryField,
            displayNumLabel, displayNumberField, phoneLabel, phoneNumberField,
            durationLabel, durationField, downloadLabel, downloadSizeField,    
            addMobileButton, addMP3Button, makeCallButton, downloadMusicButton,
            displayAllButton, clearButton, logArea
        );

        // Set the final configuration for the window
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Gadget Shop App");
        stage.show();
    }

    /**
     * Reads input from the text fields, creates a new MP3 object,
     * adds it to the gadgets list, and displays a confirmation message as we were asked.
     */
    private void handleAddMP3Button() {
        // 1. Collect the data
        String model = modelField.getText();
        String size = sizeField.getText();
        // Converts the text entered into a decimal number, removing any accidental spaces
        double price = Double.parseDouble(priceField.getText().trim()); //.trim is use to cut/delete blank spaces
        // Convert the weight text to an integer
        int weight = Integer.parseInt(weightField.getText().trim());
        // Convert the text from memory to an integer
        int memory = Integer.parseInt(memoryField.getText().trim()); 

        // 2. Creates the MP3 and saves it
        MP3 newMP3 = new MP3(model, price, weight, size, memory);
        gadgets.add(newMP3);

        // 3. Confirmation message 
        logArea.appendText("MP3 added: " + model + " (" + memory + " MB)\n");
    }

    /**
     * Reads input from the text fields, creates a new Mobile object,
     * adds it to the gadgets list, and displays a confirmation message.
     */
    private void handleAddMobileButton() {
        // 1. Collect the data
        String model = modelField.getText();
        String size = sizeField.getText();
        double price = Double.parseDouble(priceField.getText().trim());
        int weight = Integer.parseInt(weightField.getText().trim());
        int credit = Integer.parseInt(creditField.getText().trim());

        // 2. Create object and saves it 
        Mobile newMobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(newMobile);

        // 3. Confirmation message
        logArea.appendText("Added Mobile: " + model + "\n");
    }

    /**
     * Safely retrieves and validates the display number entered by the user.
     * It uses a try/catch block to prevent the program from crashing if invalid data is entered.
     * * @return the valid display number (index), or -1 if the input is invalid
     */
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

    /**
     * Clears the display area and loops through the gadgets ArrayList,
     * calling the display method on each gadget to show its details.
     */
    private void handleDisplayAllButton() {
        // 1. This part is made to clear the logArea from previous details displayed on it 
        logArea.clear();
        logArea.appendText("=== Gadget List ===\n");
        
        // 2. Loop "for" that goes over our list from 0 to the end 
        for (int i = 0; i < gadgets.size(); i++) {
            // Print the display number as requested 
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

    /**
     * Retrieves the selected Mobile gadget using the display number and simulates
     * making a phone call by deducting credit based on duration.
     */
    private void handleMakeCallButton() {
        // 1. Get the display number using our safe method
        int displayNum = getDisplayNumber();

        // 2. Only proceed if the display number is valid (not -1)
        if (displayNum != -1) {
            String phoneNumber = phoneNumberField.getText();
            int duration = Integer.parseInt(durationField.getText().trim());

            // Retrieves the gadget from the ArrayList using the valid display number
            Gadget currentGadget = gadgets.get(displayNum);

            // Convert the generic Gadget object into a Mobile object
            Mobile mobile = (Mobile) currentGadget;

            // Calls the makeCall method in the Mobile class passing the input values
            mobile.makeCall(phoneNumber, duration);

            // Displays a message confirming that it work and it displays in the text area
            logArea.appendText("Calling " + phoneNumber + " for " + duration + " minutes.\n");
        }
    }

    /**
     * Retrieves the selected MP3 gadget using the display number and simulates
     * downloading music by checking and deducting available memory.
     */
    private void handleDownloadMusicButton() {
        // 1. Get the display number using our safe method
        int displayNum = getDisplayNumber();

        // 2. Only proceed if the display number is valid (not -1)
        if (displayNum != -1) {
            int downloadSize = Integer.parseInt(downloadSizeField.getText().trim());

            // Retrieves the gadget from the ArrayList using the valid display number
            Gadget currentGadget = gadgets.get(displayNum);

            // Convert the generic Gadget object into an MP3 object
            MP3 mp3 = (MP3) currentGadget;

            // Calls the downloadMusic method in the MP3 class passing the input size
            mp3.downloadMusic(downloadSize);

            // Displays a message confirming that it work and it displays in the text area
            logArea.appendText("Downloaded " + downloadSize + " MB to MP3.\n");
        }
    }

    /**
     * Clears all the input text fields in the GUI to prepare for new data input.
     */
    private void clearAllFields(){
        modelField.clear();
        priceField.clear();
        weightField.clear();
        sizeField.clear();
        creditField.clear();
        memoryField.clear();
        displayNumberField.clear();
        phoneNumberField.clear();
        durationField.clear();
        downloadSizeField.clear();
    }
    
    /**
     * The main entry point for the JavaFX application to work.
     * * @param args the command line arguments
     */
    public static void main(String[] args) { 
        launch(); 
    }
}
