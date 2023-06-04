package ToyStore;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int drop_rate;


    public Toy(int id, String name, int count, int drop_rate) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.drop_rate = drop_rate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getDropRate() {
        return drop_rate;
    }
    public void setDropRate(int drop_rate) {
        this.drop_rate = drop_rate;
    }

    @Override
    public String toString() {
        return "id=" + this.id + ", название=" + this.name + ", количество=" + this.count + ", вес=" + this.drop_rate + "\n";
    }
}
