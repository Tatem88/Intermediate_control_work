package ToyStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToyStore {
    private ArrayList<Toy> toys = new ArrayList<Toy>();
    private ArrayList<Toy> prizeToys = new ArrayList<Toy>();
    private Random random = new Random();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void editToyDropRate(int id, int drop_rate) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setDropRate(drop_rate);
            }
        }
    }

    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null;
        }
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        decreaseToyCount(prizeToy);
        savePrizeToyToFile(prizeToy);
        return prizeToy;
    }

    public void choosePrizeToy() {
        double totalDropRate = 0;
        for (Toy toy : toys) {
            totalDropRate += toy.getDropRate();
        }
        double randomValue = random.nextDouble() * totalDropRate;
        int droprateSum = 0;
        for (Toy toy : toys) {
            droprateSum += toy.getDropRate();
            if (randomValue <= droprateSum) {
                prizeToys.add(toy);
                break;
            }
        }
    }

    private void decreaseToyCount(Toy toy) {
        for (Toy t : toys) {
            if (t.getId() == toy.getId()) {
                t.setCount(t.getCount() - 1);
                break;
            }
        }
    }

    private void savePrizeToyToFile(Toy toy) {
        String fileName = "toys.txt";
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file, true);
            writer.write(toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public String toString() {
        return "Toy Store: Toys =" + this.toys + "}";
    }
}

