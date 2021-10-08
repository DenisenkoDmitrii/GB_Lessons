package Lesson_07;

/*
Lesson_07 (GB.Java 1)
Denisenko Dmitrii (30.09.2021)
 */
public class Lesson_07 {

    public static void main(String[] args) {
        Cat catBarsik = new Cat("Кот Барсик", 5);
        Cat catMurzik = new Cat("Кот Мурзик", 6);
        Cat catWiskas = new Cat("Кот Вискас", 7);
        Plate whitePlate = new Plate("белая тарелка", 15);

        Cat cats[] = {catBarsik, catMurzik, catWiskas};
        whitePlate.info();
        for (Cat i : cats) {
            i.eat(whitePlate);
        }
        whitePlate.info();
        for (Cat i : cats) {
            if (i.getIsHungry()) {
                System.out.println(i.getName() + " голодный");
            } else {
                System.out.println(i.getName() + " сытый");
            }
        }
        System.out.println("В тарелку добавлена еда");
        whitePlate.setFoodVolume(4);
        whitePlate.info();
        for (Cat i : cats) {
            i.eat(whitePlate);
        }
        for (Cat i : cats) {
            if (i.getIsHungry()) {
                System.out.println(i.getName() + " голодный");
            } else {
                System.out.println(i.getName() + " сытый");
            }
        }
        whitePlate.info();
    }
}
