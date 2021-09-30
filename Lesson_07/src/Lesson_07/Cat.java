package Lesson_07;

public class Cat {
    protected String name;
    protected int appetite;
    protected boolean isHungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (isHungry) {
            boolean isEated = p.decreaseFood(appetite);
            if (isEated) {
                System.out.println(name + " съел " + appetite + " единиц еды");
                isHungry = false;
            } else {
                System.out.println(name + " не стал трогать еду, т.к. её мало для его аппетита");
            }
        } else {
            System.out.println(name + " не кушает, т.к. не голодный");
        }
    }

    public boolean getIsHungry() {
        return isHungry;
    }

    public String getName() {
        return name;
    }
}
