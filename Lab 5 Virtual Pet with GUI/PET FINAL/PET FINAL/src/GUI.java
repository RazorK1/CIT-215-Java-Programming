import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Pet pet;
    private JLabel petImageLabel;
    private JLabel thirstLabel, happinessLabel, ageLabel, nameLabel;
    private JButton playButton, drinkButton, sleepButton;
    private Timer timer;

    public GUI() {
        // Input Pet's Name
        String name = JOptionPane.showInputDialog("Pet's Name?");

        // Assign's input to pet name
        pet = new Pet(name);

        // Set up frame
        setTitle("Virtual Pet");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout

        // Load and scale the pet image
        ImageIcon originalIcon = new ImageIcon("Resources/Pictures/doggo baby.jpg"); // Replace with actual image path
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Adjust width and height as needed
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Pet Image Label
        petImageLabel = new JLabel(scaledIcon);
        add(petImageLabel, BorderLayout.NORTH); // Place at the top

        // Labels
        thirstLabel = new JLabel("Thirst: " + pet.getThirst());
        happinessLabel = new JLabel("Happiness: " + pet.getHappiness());
        ageLabel = new JLabel("Age: " + pet.getAge());
        nameLabel = new JLabel("Name: " + pet.getName());

        // Create a panel for labels
        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(thirstLabel);
        labelPanel.add(happinessLabel);
        labelPanel.add(ageLabel);
        labelPanel.add(nameLabel);

        // Buttons
        playButton = new JButton("Play");
        drinkButton = new JButton("Drink");
        sleepButton = new JButton("Sleep");

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(playButton);
        buttonPanel.add(drinkButton);
        buttonPanel.add(sleepButton);

        // Create a main panel to hold the labels and buttons
        JPanel mainPanel = new JPanel(new GridLayout(2, 1)); // Arrange in 2 rows
        mainPanel.add(labelPanel);
        mainPanel.add(buttonPanel);

        // Add the main panel to the center of the frame
        add(mainPanel, BorderLayout.CENTER);

        // Play Button action
        playButton.addActionListener(e -> {
            pet.play();
            playSound("Resources/UI/Click_04.wav"); // Replace with the actual file path
            updateLabels();
        });

        // Drink Button action
        drinkButton.addActionListener(e -> {
            pet.drink();
            playSound("Resources/UI/Click_04.wav"); // Replace with the actual file path
            updateLabels();
        });

        // Sleep Button action
        sleepButton.addActionListener(e -> {
            pet.sleep();
            playSound("Resources/UI/Click_04.wav"); // Replace with the actual file path
            updateLabels();
        });

        // Timer to decrease stats over time
        timer = new Timer(5000, e -> {
            pet.age(); // Simulate passive stat decrease
            updateLabels();
            playSound("Resources/UI/Click_03.wav"); // Replace with the actual file path
            checkPetStatus();
        });
        timer.start();

        setVisible(true);
    }

    private void updateLabels() {
        thirstLabel.setText("Thirst: " + pet.getThirst());
        happinessLabel.setText("Happiness: " + pet.getHappiness());
        ageLabel.setText("Age: " + pet.getAge());
    }

    private void checkPetStatus() {
        // Adjust images based on pet's age
        String imagePath;
        if (pet.getAge() <= 3 && pet.getThirst() > 0 && pet.getHappiness() > 0) {
            imagePath = "Resources/Pictures/doggo baby.jpg";
        } else if (pet.getAge() <= 9 && pet.getThirst() > 0 && pet.getHappiness() > 0) {
            imagePath = "Resources/Pictures/doggo young.jpg";
        } else if (pet.getAge() <= 14 && pet.getThirst() > 0 && pet.getHappiness() > 0){
            imagePath = "Resources/Pictures/doggo old.jpg";
        } else {
            imagePath = "Resources/Pictures/doggo skeleton.jpg";
        }

        // Scale the new image before updating the icon
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        petImageLabel.setIcon(new ImageIcon(scaledImage));
    }

    //PlaySound Function
    private void playSound(String soundFile) {
        try {
            File audioFile = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Adjust the volume
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f); // Reduce volume by decibels

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}