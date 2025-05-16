import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Pet {
    // Private instance variables
    private String name;
    private int thirst;
    private int happiness;
    private int age;

    // Constructor
    public Pet(String petName) {
        this.name = petName;
        this.thirst = 100;
        this.happiness = 100;
        this.age = 0;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getAge() {
        return age;
    }

    // Setter methods (if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setThirst(int thirst) {
        this.thirst = Math.max(0, Math.min(thirst, 100)); // Ensure thirst stays between 0-100
    }

    public void setHappiness(int happiness) {
        this.happiness = Math.max(0, Math.min(happiness, 100)); // Ensure happiness stays between 0-100
    }

    public void setAge(int age) {
        this.age = Math.max(0, Math.min(age, 15)); // Ensure happiness stays between 0-100
    }

    // Pet actions
    public void play() {
        setHappiness(happiness + 20);
        setThirst(thirst - 10);
        System.out.println(name + " played!");
    }

    public void drink() {
        setThirst(thirst + 30);
        System.out.println(name + " drank!");
    }

    public void sleep() {
        setHappiness(happiness - 5);
        setThirst(thirst - 20);
        System.out.println(name + " slept!");
    }

    public void age() {
        setAge(age + 1);
        System.out.println(name + " aged");
    }

    // Print method
    public void print() {
        System.out.println("Pet Info: ");
        System.out.println("Name: " + name);
        System.out.println("Thirst: " + thirst);
        System.out.println("Happiness: " + happiness);
        System.out.println("Age: " + age);
    }
}
