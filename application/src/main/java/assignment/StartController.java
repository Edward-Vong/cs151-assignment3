package assignment;

import java.io.IOException;
import javafx.fxml.FXML;

public class StartController {
    @FXML
    private void switchToSignup() throws IOException {
        App.setRoot("SignupForm");
    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("LoginForm");
    }
}
