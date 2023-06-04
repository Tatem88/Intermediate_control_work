package ToyStore;

public class Raflee {
    public static void main(String[] args) {

        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Свинья", 12, 20));
        toyStore.addToy(new Toy(2, "Овца", 8, 40));
        toyStore.addToy(new Toy(3, "Кукла",5, 30));
        toyStore.addToy(new Toy(4, "Машинка", 3, 8));
        toyStore.addToy(new Toy(5, "Волк", 15, 20));
        toyStore.addToy(new Toy(6, "Птичка", 10, 49));
        toyStore.addToy(new Toy(7, "Козочка", 17, 88));


        toyStore.editToyDropRate(1, 20);
        toyStore.editToyDropRate(2, 40);
        toyStore.editToyDropRate(3, 30);
        toyStore.editToyDropRate(4, 8);
        toyStore.editToyDropRate(5, 20);
        toyStore.editToyDropRate(6, 49);
        toyStore.editToyDropRate(7, 88);


        for (int i = 0; i < 3; i++) {
            toyStore.choosePrizeToy();
            Toy prizeToy = toyStore.getPrizeToy();
            System.out.println("Toy: " + prizeToy.getName());
            System.out.println("--------------------------");
            System.out.println("Store: \n" + toyStore);
        }
    }

}

