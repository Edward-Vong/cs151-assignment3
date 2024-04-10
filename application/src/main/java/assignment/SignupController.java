package assignment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import java.util.Random;

public class SignupController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSignup() {
        String password = passwordField.getText();
        String validationResult = validatePassword(password);

        if (!validationResult.isEmpty()) {
            showAlertWithHeaderText("Signup Failed", validationResult);
            return;
        }

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = generateUsername(firstName, lastName);
        
        showAlertWithHeaderText("Signup Successful!", "Your username is: " + username);
    }

    private String validatePassword(String password) {
        StringBuilder errorMessage = new StringBuilder();

        if (!password.matches(".*[A-Z].*")) {
            errorMessage.append("UpperCaseCharacterMissing\n");
        }
        if (!password.matches(".*[a-z].*")) {
            errorMessage.append("LowerCaseCharacterMissing\n");
        }
        if (!password.matches(".*[!@#$%^&*()].*")) { 
            errorMessage.append("SpecialCharacterMissing\n");
        }
        if (!password.matches(".*[0-9].*")) {
            errorMessage.append("NumberCharacterMissing\n");
        }
        if (password.length() < 8) {
            errorMessage.append("Minimum8CharactersRequired\n");
        }

        return errorMessage.toString();
    }

    private String generateUsername(String firstName, String lastName) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000); 
        return "" + Character.toUpperCase(firstName.charAt(0)) + 
                   Character.toUpperCase(lastName.charAt(0)) + 
                   "-" + 
                   randomNumber;
    }

    private void showAlertWithHeaderText(String headerText, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Signup Info");
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
