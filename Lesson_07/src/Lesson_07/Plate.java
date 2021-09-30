package Lesson_07;

public class Plate {
    protected String name;
    protected int foodVolume;

    public Plate(String name, int foodVolume) {
        this.name = name;
        this.foodVolume = foodVolume;
    }

    public boolean decreaseFood(int n) {
        if (n <= foodVolume) {
            foodVolume -= n;
            return true;
        } else {
            return false;
        }
    }

    public void info() {
        System.out.println("Сейчас в " + name + " имеется: " + foodVolume + " единиц еды");
    }

    public int setFoodVolume(int addFood) {
        return foodVolume += addFood;
    }
}
