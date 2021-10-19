package Lesson_06;

public abstract class Animal implements IAnimal {
    protected String name;
    protected int runDistanceLimit = 0;
    protected int swimDistanceLimit = 0;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int runDistance) {
        if (runDistance <= runDistanceLimit && runDistanceLimit != 0 && runDistance != 0) {
            System.out.println(name + " пробежал: " + runDistance + " метров");
        } else if (runDistance == 0 && runDistanceLimit == 0) {
            System.out.println(name + " не начинал бегать");
        } else if (runDistanceLimit == 0) {
            System.out.println(name + " не будет бегать, т.к. не умеет");
        } else if (runDistance == 0) {
            System.out.println(name + " не начинал бегать");
        } else {
            System.out.println(name + " не пробежал " + runDistance + " м., т.к. не может бежать больше " + runDistanceLimit + " метров");
        }
    }

    public void swim(int swimDistance) {
        if (swimDistance <= swimDistanceLimit && swimDistanceLimit != 0 && swimDistance != 0) {
            System.out.println(name + " проплыл: " + swimDistance + " метров");
        } else if (swimDistance == 0 && swimDistanceLimit == 0) {
            System.out.println(name + " так и не залез в воду");
        } else if (swimDistanceLimit == 0) {
            System.out.println(name + " не будет плавать, т.к. не умеет");
        } else if (swimDistance == 0) {
            System.out.println(name + " так и не залез в воду");
        } else {
            System.out.println(name + " не проплыл " + swimDistance + " м., т.к. не может плыть больше " + swimDistanceLimit + " метров");
        }
    }
}
