import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGame extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[][] questions = {
        {"What is the capital of France?", "Paris", "London", "Berlin", "Rome", "Paris"},
        {"Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn", "Mars"},
        {"What is the largest mammal in the world?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus", "Blue Whale"},
        {"Who painted the Mona Lisa?", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", "Leonardo da Vinci"},
        {"What is the largest ocean in the world?", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean", "Pacific Ocean"},
        {"Who is the author of the Harry Potter series?", "J.K. Rowling", "Stephen King", "George R.R. Martin", "J.R.R. Tolkien", "J.K. Rowling"},
        {"What is the chemical symbol for the element Gold?", "Au", "Ag", "Pt", "Hg", "Au"},
        {"Which country is famous for the ancient city of Petra?", "Greece", "Egypt", "Jordan", "Turkey", "Jordan"},
        {"What is the currency of Japan?", "Yuan", "Dollar", "Pound", "Yen", "Yen"},
        {"Who was the first person to step on the Moon?", "Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "John Glenn", "Neil Armstrong"}
    };
    

    public QuizGame() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 1));

        questionLabel = new JLabel(questions[currentQuestionIndex][0], JLabel.CENTER);
        add(questionLabel);

        ButtonGroup group = new ButtonGroup();
        options = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(questions[currentQuestionIndex][i + 1]);
            group.add(options[i]);
            add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            checkAnswer();
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                endQuiz();
            }
        }
    }

    private void checkAnswer() {
        for (JRadioButton option : options) {
            if (option.isSelected() && option.getText().equals(questions[currentQuestionIndex][5])) {
                score++;
                break;
            }
        }
    }

    private void displayQuestion() {
        questionLabel.setText(questions[currentQuestionIndex][0]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(questions[currentQuestionIndex][i + 1]);
            options[i].setSelected(false);
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz ended. Your score is: " + score + "/" + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}
