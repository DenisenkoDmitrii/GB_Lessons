package Lesson_01;

public class Member {
    protected String memberName;
    protected int memberDistanseLimit;
    protected boolean isFinished;

    public Member(String memberName, int memberDistanseLimit) {
        this.memberName = memberName;
        this.memberDistanseLimit = memberDistanseLimit;
    }

    public void memberInfo(){
        System.out.println("Имя: " + memberName + ", пробегает " + memberDistanseLimit + " м.");
    }
}
