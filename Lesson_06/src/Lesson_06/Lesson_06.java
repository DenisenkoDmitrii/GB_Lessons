package Lesson_06;

public class Lesson_06 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Кот Барсик");
        Dog dog1 = new Dog("Пёс Шарик");
        Worm worm1 = new Worm("Червяк Валера");

        Animal zoo[] = {cat1, dog1, worm1};
        for (Animal i : zoo) {
            i.run(0);
            i.run(150);
            i.run(501);
            i.swim(0);
            i.swim(5);
            System.out.println();
        }

        for (IAnimal i : zoo) {
            i.voice();
            i.colour();
            System.out.println();
        }
    }
}
