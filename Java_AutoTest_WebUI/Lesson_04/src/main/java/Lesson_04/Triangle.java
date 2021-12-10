package Lesson_04;

public class Triangle {
    int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Площадь треугольника по формуле Герона
    public double getSquare() throws My_isTriangleException {
        double p;
        double square;
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new My_isTriangleException();
        } else {
            p = (a + b + c) / 2;
            square = Math.sqrt((p * (p - a) * (p - b) * (p - c)));
        }
        return square;
    }


}
