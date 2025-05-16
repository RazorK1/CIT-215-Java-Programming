import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;

public class PokemonGUI {
    private JFrame frame;
    private JLabel imageLabel;
    private JTextArea infoLabel;
    private JButton nextButton;
    private ArrayList<Pokemon> pokemonList;
    private int currentIndex = 0;

    // Labels for stats
    private JLabel nameLabel;
    private JLabel hpLabel;
    private JLabel attackLabel;
    private JLabel defenseLabel;
    private JLabel speedLabel;
    private JLabel numberLabel;
    private JLabel type1Label;
    private JLabel type2Label;

    public PokemonGUI(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;

        frame = new JFrame("Pokemon Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);  // Increased size to accommodate the new labels
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        // Info label (description)
        infoLabel = new JTextArea(5, 20);
        infoLabel.setWrapStyleWord(true);
        infoLabel.setLineWrap(true);
        infoLabel.setEditable(false);
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(new JScrollPane(infoLabel), BorderLayout.SOUTH);

        // Stats labels
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(8, 1));  // 4 rows for stats

        nameLabel = new JLabel("Name: ");
        numberLabel = new JLabel("#: ");
        hpLabel = new JLabel("HP: ");
        attackLabel = new JLabel("Attack: ");
        defenseLabel = new JLabel("Defense: ");
        speedLabel = new JLabel("Speed: ");
        type1Label = new JLabel("Type 1: ");
        type2Label = new JLabel("Type 2: ");

        // Set horizontal alignment for labels
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        numberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        hpLabel.setHorizontalAlignment(SwingConstants.LEFT);
        attackLabel.setHorizontalAlignment(SwingConstants.LEFT);
        defenseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        speedLabel.setHorizontalAlignment(SwingConstants.LEFT);
        type1Label.setHorizontalAlignment(SwingConstants.LEFT);
        type2Label.setHorizontalAlignment(SwingConstants.LEFT);

        // Add labels to stats panel
        statsPanel.add(nameLabel);
        statsPanel.add(numberLabel);
        statsPanel.add(hpLabel);
        statsPanel.add(attackLabel);
        statsPanel.add(defenseLabel);
        statsPanel.add(speedLabel);
        statsPanel.add(type1Label);
        statsPanel.add(type2Label);

        frame.add(statsPanel, BorderLayout.WEST);  // Position stats on the right

        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showNextPokemon());
        frame.add(nextButton, BorderLayout.NORTH);

        showPokemon();  // Show the first Pokemon
        frame.setVisible(true);
    }

    private void showPokemon() {
        if (pokemonList.isEmpty()) return;
        Pokemon p = pokemonList.get(currentIndex);

        try {
            // Load image from URL
            ImageIcon icon = new ImageIcon(new java.net.URL(p.getImageUrl()));
            imageLabel.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
            imageLabel.setText("Image not found");
        }

        // Set the description in the info label
        infoLabel.setText(p.toString());

        // Update the stats labels
        nameLabel.setText("Name: " + p.getName());
        numberLabel.setText("#: " + p.getNumber());
        hpLabel.setText("HP: " + p.getHp());
        attackLabel.setText("Attack: " + p.getAttack());
        defenseLabel.setText("Defense: " + p.getDefense());
        speedLabel.setText("Speed: " + p.getSpeed());
        type1Label.setText("Type 1: " + p.getType1());
        type2Label.setText("Type 2: " + p.getType2());
    }

    private void showNextPokemon() {
        currentIndex = (currentIndex + 1) % pokemonList.size();
        showPokemon();
    }

    public static ArrayList<Pokemon> loadFile(String filePath) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                // Use regex to handle commas inside quotes and split by commas properly
                String regex = "(?<=^|,)(\"([^\"]*)\"|([^,]*))(,|$)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                List<String> fields = new ArrayList<>();

                while (matcher.find()) {
                    String field = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    fields.add(field);
                }

                // Ensure we have the correct number of fields (10 fields)
                if (fields.size() == 10) {
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

                    // Remove extra quotes from description if present
                    if (description.startsWith("\"") && description.endsWith("\"")) {
                        description = description.substring(1, description.length() - 1);
                    }

                    Pokemon pokemon = new Pokemon(number, name, type1, type2, hp, attack, defense, speed, imageUrl, description);
                    pokemonList.add(pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }

    public static void main(String[] args) {
        ArrayList<Pokemon> pokemonList = loadFile("Resources/pokemon.csv");
        SwingUtilities.invokeLater(() -> new PokemonGUI(pokemonList));
    }
}
