package Engine;

import GUI.LogInForm;

public class StartPoint {
    public static void main(String[] args) {
        LogInForm logInFormInstance = new LogInForm();
        logInFormInstance.setResizable(false);
        logInFormInstance.setLocationRelativeTo(null);
        logInFormInstance.setVisible(true);
    }
}
