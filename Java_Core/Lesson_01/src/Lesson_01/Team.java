package Lesson_01;

public class Team {
    protected String teamName;

    Member members_1[];

    public Team(String teamName, Member member1, Member member2, Member member3) {
        this.teamName = teamName;
        members_1 = new Member[]{member1, member2, member3};
    }

    public void teamInfo() {
        for (Member member : members_1) {
            member.memberInfo();
        }
    }

    public void teamInfoMembersFinished() {
        for (Member member : members_1) {
            if (member.isFinished) {
                member.memberInfo();
            }
        }
    }
}
