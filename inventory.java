import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class inventory extends Application {

    private final ObservableList<String> inventory = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        // Create TextField for input
        TextField inputField = new TextField();
        inputField.setPromptText("Enter item name");

        // Create ListView to display items
        ListView<String> listView = new ListView<>(inventory);

        // Create Buttons
        Button addButton = new Button("Add Item");
        Button updateButton = new Button("Update Item");
        Button deleteButton = new Button("Delete Item");

        // Add Button Action
        addButton.setOnAction(e -> {
            String item = inputField.getText().trim();
            if (!item.isEmpty()) {
                inventory.add(item);
                inputField.clear();
            } else {
                showAlert("Invalid Input", "Please enter a valid item name.");
            }
        });

        // Update Button Action
        updateButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                String newItem = showTextInputDialog("Update Item", "Enter new name for the selected item:", selectedItem);
                if (newItem != null && !newItem.trim().isEmpty()) {
                    int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                    inventory.set(selectedIndex, newItem);
                }
            } else {
                showAlert("No Selection", "Please select an item to update.");
            }
        });

        // Delete Button Action
        deleteButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                inventory.remove(selectedItem);
            } else {
                showAlert("No Selection", "Please select an item to delete.");
            }
        });

        // Layout for input and buttons
        HBox inputLayout = new HBox(10, inputField, addButton);
        HBox buttonLayout = new HBox(10, updateButton, deleteButton);
        inputLayout.setStyle("-fx-padding: 10; -fx-alignment: center;");
        buttonLayout.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Main layout
        VBox mainLayout = new VBox(10, listView, inputLayout, buttonLayout);
        BorderPane root = new BorderPane(mainLayout);

        // Scene setup
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Inventory App");
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String showTextInputDialog(String title, String message, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        return dialog.showAndWait().orElse(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
