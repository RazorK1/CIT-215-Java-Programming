/// Author: Kyle Harris
/// CIT-215/CIT-215L Java Programming D01

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;

public class PokemonQuizGame {
    private JFrame frame;
    private JLabel imageLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton nextButton;
    private JLabel scoreLabel;
    private int score = 0;
    private ArrayList<Pokemon> pokemonList;
    private HashMap<String, Pokemon> pokemonMap;
    private int currentIndex;

    public PokemonQuizGame(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.pokemonMap = createPokemonMap(pokemonList);

        frame = new JFrame("Pokemon Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500); // Sets Size of Gui
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Puts GUI in the center of the default screen.

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER); // Puts image in the center

        answerField = new JTextField(20);
        frame.add(answerField, BorderLayout.NORTH); // Puts answerField to the top

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> checkAnswer());
        frame.add(submitButton, BorderLayout.SOUTH); // Puts submitButton at the bottom

        nextButton = new JButton("Next"); // Probably going to remove nextButton
        nextButton.addActionListener(e -> showNextPokemon()); //
        frame.add(nextButton, BorderLayout.EAST); // Puts nextButton to the right

        scoreLabel = new JLabel("Score: 0");
        frame.add(scoreLabel, BorderLayout.WEST); // Puts scoreLabel to the left

        showPokemon();
        frame.setVisible(true);
    }

    private void showPokemon() {
        if (pokemonList.isEmpty()) return;
        int random = (int)(Math.random() * pokemonList.size()); // Randomizes Pokemon
        currentIndex = random; // Random pokemon Generator
        Pokemon p = pokemonList.get(currentIndex);

        try {
            ImageIcon icon = new ImageIcon(new java.net.URL(p.getImageUrl()));
            imageLabel.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
            imageLabel.setText("Image not found"); // Realistically don't need this
        }
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim().toLowerCase();
        Pokemon guessedPokemon = pokemonMap.get(userAnswer);
        Pokemon currentPokemon = pokemonList.get(currentIndex);

        if (guessedPokemon != null && guessedPokemon.equals(currentPokemon)) {
            score++;
            JOptionPane.showMessageDialog(frame, "Correct!\n" +
                    "Name: " + guessedPokemon.getName() + "\n" +
                    "Number: " + guessedPokemon.getNumber() + "\n" +
                    "Type: " + guessedPokemon.getType1() + (guessedPokemon.getType2().isEmpty() ? "" : ", " + guessedPokemon.getType2()) + "\n" +
                    "HP: " + guessedPokemon.getHp() + "\n" +
                    "Attack: " + guessedPokemon.getAttack() + "\n" +
                    "Defense: " + guessedPokemon.getDefense() + "\n" +
                    "Speed: " + guessedPokemon.getSpeed() + "\n" +
                    "Description: " + guessedPokemon.getDescription()); // Getters

        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect! The correct answer was: " + currentPokemon.getName());
        }

        scoreLabel.setText("Score: " + score);
        answerField.setText("");
        showNextPokemon(); // Function call
    }

    private void showNextPokemon() {
        int random = (int)(Math.random() * pokemonList.size());
        currentIndex = random; // Random Pokemon Generator
        showPokemon(); // Function call
    }

    public static ArrayList<Pokemon> loadFile(String filePath) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.remove(0);

            for (String line : lines) {
                String regex = "(?<=^|,)(\"([^\"]*)\"|([^,]*))(,|$)";// .CSV file reader
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                List<String> fields = new ArrayList<>();

                while (matcher.find()) { // Used for the previous regex
                    String field = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    fields.add(field);
                }

                if (fields.size() == 10) { // Goes through the stats of the pokemon
                    int number = Integer.parseInt(fields.get(0));
                    String name = fields.get(1);
                    String type1 = fields.get(2);
                    String type2 = fields.get(3).isEmpty() ? "" : fields.get(3);
                    int hp = Integer.parseInt(fields.get(4));
                    int attack = Integer.parseInt(fields.get(5));
                    int defense = Integer.parseInt(fields.get(6));
                    int speed = Integer.parseInt(fields.get(7));
                    String imageUrl = fields.get(8);
                    String description = fields.get(9);

                    if (description.startsWith("\"") && description.endsWith("\"")) { // This is unneeded because
                        description = description.substring(1, description.length() - 1); // Descriptions are not used.
                    }

                    Pokemon pokemon = new Pokemon(number, name, type1, type2, hp, attack, defense, speed, imageUrl, description);
                    pokemonList.add(pokemon);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemonList;
    }

    public static HashMap<String, Pokemon> createPokemonMap(ArrayList<Pokemon> pokemonList) { // HashMap Function
        HashMap<String, Pokemon> pokemonMap = new HashMap<>();
        for (Pokemon p : pokemonList) {
            pokemonMap.put(p.getName().toLowerCase(), p);
        }
        return pokemonMap;
    }

    public static void main(String[] args) {
        ArrayList<Pokemon> pokemonList = loadFile("Resources/pokemon.csv"); // .CSV loader
        SwingUtilities.invokeLater(() -> new PokemonQuizGame(pokemonList));
    }
}
