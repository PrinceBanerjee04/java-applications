import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGuessingGame extends JFrame {
    private int targetNumber;
    private JTextField guessField;
    private JLabel hintLabel;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        targetNumber = (int) (Math.random() * 100) + 1;
        
        JLabel titleLabel = new JLabel("Guess a number between 1 and 100:");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        hintLabel = new JLabel("Take a guess...");

        guessButton.addActionListener(new GuessListener());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(titleLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(hintLabel);

        add(panel);
        setVisible(true);
    }

    private class GuessListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                int userGuess = Integer.parseInt(guessField.getText());

                if (userGuess < targetNumber) {
                    hintLabel.setText("Try a higher number.");
                } else if (userGuess > targetNumber) {
                    hintLabel.setText("Try a lower number.");
                } else {
                    hintLabel.setText("Congratulations! You guessed it.");
                }

                guessField.setText("");
            } catch (NumberFormatException e) {
                hintLabel.setText("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessingGame());
    }
}
