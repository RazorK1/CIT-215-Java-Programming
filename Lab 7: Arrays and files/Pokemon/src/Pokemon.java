public class Pokemon {
    private int number;
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private String imageUrl;
    private String description;

    public Pokemon(int number, String name, String type1, String type2, int hp, int attack, int defense, int speed, String imageUrl, String description) {
        this.number = number;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getNumber() { return number; }
    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " (" + type1 + (type2.isEmpty() ? "" : "/" + type2) + ") - " + description;
    }
}
