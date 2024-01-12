import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        rockButton = new JButton("Rock");
        rockButton.addActionListener(this);
        panel.add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.addActionListener(this);
        panel.add(paperButton);

        scissorsButton = new JButton("Scissors");
        scissorsButton.addActionListener(this);
        panel.add(scissorsButton);

        resultLabel = new JLabel("Choose your move!");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userMove = e.getActionCommand();
        String computerMove = generateComputerMove();
        String result = determineWinner(userMove, computerMove);
        resultLabel.setText("You chose " + userMove + ". Computer chose " + computerMove + ". " + result);
    }
private String generateComputerMove() {
        Random random = new Random();
        int move = random.nextInt(3);
        switch (move) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "";
        }
    }

    private String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        } else if ((userMove.equals("Rock") && computerMove.equals("Scissors")) ||
                   (userMove.equals("Paper") && computerMove.equals("Rock")) ||
                   (userMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
    
}
