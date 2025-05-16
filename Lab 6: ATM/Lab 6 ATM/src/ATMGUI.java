import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ATMGUI extends JFrame {
    private JPanel panelMain;
    private JButton printBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JTextField amountField;
    private JLabel outputLabel;
    private JLabel balanceLabel;

    private BankAccount account;

    public ATMGUI() {
        //////// Initialize components manually (if UI Designer didn't do it.
        panelMain = new JPanel(new GridLayout(4, 2));
        printBalanceButton = new JButton("Print Balance");
        depositButton = new JButton("Deposit"); //////////////// Deposit button
        withdrawButton = new JButton("Withdraw"); //////////////// Withdraw button
        amountField = new JTextField();
        outputLabel = new JLabel(""); ///////////////// Output label
        balanceLabel = new JLabel("Balance: $500"); /////////////// Balance labal

        ////////// Add components to panel
        panelMain.add(new JLabel("Enter Amount:"));
        panelMain.add(amountField);
        panelMain.add(printBalanceButton);
        panelMain.add(depositButton); //////////////// Deposit button
        panelMain.add(withdrawButton); //////////////// Withdraw button
        panelMain.add(outputLabel); ///////////////// Output label
        panelMain.add(balanceLabel); //////////////// Balance label

        account = new BankAccount("John Doe", 12345, 500.00);

        //////// Action Listeners
        printBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceLabel.setText(account.toString());
                playSound("Resources/Coins_02.wav");
            }
        });

        //////////Deposit button Push
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String result = account.deposit(amount); //////////Deposit Method
                    outputLabel.setText(result);
                    playSound("Resources/Coins_03.wav");
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Error: Enter a valid number.");
                    playSound("Resources/Coins_01.wav");
                }
            }
        });

        //////////Withdraw button Push
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String result = account.withdraw(amount); /////////////Withdraw Method
                    outputLabel.setText(result);
                    playSound("Resources/Coins_04.wav");
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Error: Enter a valid number.");
                    playSound("Resources/Coins_01.wav");
                }
            }
        });
    }

    ////////////////////////////PlaySound Function
    private void playSound(String soundFile) {
        try {
            File audioFile = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Adjust the volume
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); // Reduce volume by decibels

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ATM");
            frame.setContentPane(new ATMGUI().panelMain);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 250);  // SET SIZE HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //frame.pack();     DELETE COMMENT IF NEEDED
            frame.setVisible(true);

            frame.setLocationRelativeTo(null);
        });
    }
}
