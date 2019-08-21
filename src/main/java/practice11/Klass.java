package practice11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Klass {

    private final int number;
    private final Set<Student> member;
    private final Set<Teacher> teachers;

    private Student leader;

    private Klass() {
        this.number = 0;
        this.member = new HashSet<>();
        this.teachers = new HashSet<>();
    }

    public Klass(int number) {
        this.number = number;
        this.member = new HashSet<>();
        this.teachers = new HashSet<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void assignLeader(Student student) {
        if (this.member.contains(student)) {
            this.leader = student;
            for (Teacher teacher : this.teachers) {
                teacher.handleLeaderChange(student, this);
            }
        } else {
            System.out.println("It is not one of us！");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        this.member.add(student);
        for (Teacher teacher : this.teachers) {
            teacher.handleStudentJoin(student, this);
        }
    }

    void appendTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public boolean containsMember(Student student) {
        return this.member.contains(student);
    }
}
