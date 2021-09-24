package Lesson_06;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        runDistanceLimit = 200;
    }

    @Override
    public void voice() {
        System.out.println(name + "говорит: " + "Мяу!");
    }

    @Override
    public void colour() {
        String colour = "White";
        System.out.println(name + " цвета: " + colour);
    }

}
