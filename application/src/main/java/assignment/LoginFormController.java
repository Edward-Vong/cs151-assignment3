package assignment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = App.getUser(username, password);
        if (user != null) {
            String userDetails = "Login Successful!\n\n" +
                                 "First Name: " + user.getFirstName() + "\n" +
                                 "Last Name: " + user.getLastName() + "\n" +
                                 "Email: " + user.getEmail() + "\n" +
                                 "Username: " + user.getUsername();
            showAlert("Welcome!", userDetails);                     
        } else {
            showAlert("Login Failed", "Invalid username or password, or user not registered.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void back() throws IOException {
        App.setRoot("start");
    }
}
