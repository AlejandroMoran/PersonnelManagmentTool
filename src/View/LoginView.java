package src.View;

import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Login panel class
 */
public class LoginView extends JPanel implements ActionListener {
    /**
     * Logo of the program
     */
    private final ImageIcon picLogo = new ImageIcon("Resources/Images/logo.png");
    /**
     * Label for the passwordField
     */
    private final JLabel passwordLabel = new JLabel("Enter the password:");
    /**
     * Field for the password
     */
    private final JPasswordField passwordField = new JPasswordField();
    /**
     * Login button
     */
    private final JButton loginButton = new JButton("LOGIN");

    /**
     * Allocates a LoginView object and initializes it
     */
   public LoginView() {
       super(new GridBagLayout());
       setBackground(new Color(21,72,84));
       JLabel logoLabel = new JLabel(picLogo);
       logoLabel.setPreferredSize(new Dimension(550, 100));
       passwordLabel.setForeground (Color.white);
       loginButton.addActionListener(this);
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.BOTH;
       add(logoLabel,c);
       c.gridy=1;
       add(passwordLabel,c);
       c.gridy=2;
       add(passwordField,c);
       c.gridy=3;
       add(loginButton,c);
    }

    /**
     * If the login button is pressed, calls the isPasswordCorrect method of the controller with the input. If the input is correct removes the login view and calls the MenuV method of the controller, Otherwise shows an error message.
     * @param e The press of the login button
     */
    public void actionPerformed(ActionEvent e) {
       char[] input = passwordField.getPassword();
       if (Controller.isPasswordCorrect(input)) {
           System.out.println("Exit");
           super.setVisible(false);
           super.remove(this);
           Controller.MenuV();
       }
       else
           JOptionPane.showMessageDialog(this,"Invalid password. Try again.");
    }
}
