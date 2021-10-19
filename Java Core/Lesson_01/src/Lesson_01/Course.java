package Lesson_01;

public class Course {
    protected int distanse[];

    public Course(int dist1, int dist2, int dist3) {
        distanse = new int[]{dist1, dist2, dist3};
    }

    public void runCourse (Team team){
        for(Member member : team.members_1){
            for(int dist : distanse){
                if(dist <= member.memberDistanseLimit){
                    member.isFinished = true;
                }
            }
        }
    }
}
