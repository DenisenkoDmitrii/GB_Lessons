package Lesson_03;

import java.util.ArrayList;

public class Box<T extends Fruit> { //T extends Fruit - значит положить в коробки можно толкьо наследников фруктов,
    // плюс иначе не будет работать метод getWeight у наследников и " sum = sum + box.get(i).getWeight();" тут не надо делать приведение типа
    ArrayList<T> box = new ArrayList<>();

    public void addFruitsInBox(T t) {
        box.add(t);
    }

    public float getWeight() {
        float sum = 0.0f;
        for (T t : box) { // вариант: for(int i=0; i < box.size(); i++)
            sum = sum + t.getWeight(); //вариант: sum = sum + box.get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> another) { //можно написать return this.getWeight() == another.getWeight(); но и без this. компилятор понимает
        return getWeight() == another.getWeight();
    }

    public void boxShift(Box<T> another){
        for (T t : box) { //вариант for (int i=0; i < box.size(); i++) {another.addFruitsInBox(box.get(i));}
            another.addFruitsInBox(t);
        }
        this.box.clear(); //очищаем коробку из которой пересыпаем
    }
}
