package Lesson_06;

public class Dog extends Animal {

    public Dog (String name){
        super(name);
        runDistanceLimit = 500;
        swimDistanceLimit = 10;
    }

    @Override
    public void voice() {
        System.out.println(name + "говорит: " + "Гав!");
    }

    @Override
    public void colour() {
        String colour = "Brown";
        System.out.println(name + " цвета: " + colour);
    }

}
