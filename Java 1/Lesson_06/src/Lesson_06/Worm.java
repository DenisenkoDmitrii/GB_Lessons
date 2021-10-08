package Lesson_06;

public class Worm extends Animal {

    public Worm(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println(name + " не умеет говорить.");
    }

    @Override
    public void colour() {
        String colour = "Red";
        System.out.println(name + " цвета: " + colour);
    }
}
