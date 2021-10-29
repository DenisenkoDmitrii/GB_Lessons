package Lesson_03;

/*
Lesson_03 (GB.Java Core)
Denisenko Dmitriy (29.10.2021)
 */
public class Lesson_03 {

    public static void main(String[] args) {

        Box<Apple> apple_box_1 = new Box<Apple>(); // Создаём коробку под яблоки
        Box<Apple> apple_box_2 = new Box<Apple>();
        Apple apple1 = new Apple(); // Создаём 3 яблока
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Box<Orange> orange_box_1 = new Box<Orange>(); // Создаём коробку под апельсины
        Orange orange1 = new Orange(); // Создаём 4 апельсина
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        apple_box_1.addFruitsInBox(apple1); //добавляем яблоки в коробку с яблоками
        apple_box_1.addFruitsInBox(apple2);
        apple_box_1.addFruitsInBox(apple3);

        orange_box_1.addFruitsInBox(orange1); //добавляем яблоки в коробку с яблоками
        orange_box_1.addFruitsInBox(orange2);
        orange_box_1.addFruitsInBox(orange3);
        orange_box_1.addFruitsInBox(orange4);

        System.out.println("Вес коробки с яблоками: " + apple_box_1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orange_box_1.getWeight());

        System.out.print("Вес коробок с яблоками и апельсинами: ");
        if (apple_box_1.compare(orange_box_1)) {
            System.out.println("равен");
        } else {
            System.out.println("различается");
        }
        System.out.println("Пересыпаем из коробки 1 в коробку 2");
        apple_box_1.boxShift(apple_box_2); // пересыпаем из коробки 1 в коробку 2
        System.out.println("Вес коробки1 с яблоками: " + apple_box_1.getWeight());
        System.out.println("Вес коробки2 с яблоками: " + apple_box_2.getWeight());




    }
}
