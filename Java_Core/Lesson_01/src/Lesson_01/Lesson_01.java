package Lesson_01;

/*
Lesson_07 (GB.Java Core)
Denisenko Dmitrii (19.10.2021)
 */
public class Lesson_01 {

    public static void main(String[] args) {
        Member member_1_1 = new Member("Василий", 115);
        Member member_1_2 = new Member("Виталий", 125);
        Member member_1_3 = new Member("Володя", 135);
        Member member_2_1 = new Member("Иван", 115);
        Member member_2_2 = new Member("Лидия", 125);
        Member member_2_3 = new Member("Александр", 135);
        Team team_1 = new Team("Комманда 1 этажа", member_1_1, member_1_2, member_1_3);
        Team team_2 = new Team("Комманда 2 этажа", member_2_1, member_2_2, member_2_3);
        Course course1 = new Course(150, 130, 140);

        course1.runCourse(team_1);
        System.out.println("\nКомманда 1 этажа : ");
        team_1.teamInfo();
        System.out.println("\nЧлены комманды 1 этажа, которые смогли завершить пробег дистанции ");
        team_1.teamInfoMembersFinished();

        course1.runCourse(team_2);
        System.out.println("\nКомманда 2 этажа : ");
        team_2.teamInfo();
        System.out.println("\nЧлены комманды 2 этажа, которые смогли завершить пробег дистанции ");
        team_2.teamInfoMembersFinished();
    }
}
